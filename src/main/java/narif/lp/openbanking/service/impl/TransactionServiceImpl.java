package narif.lp.openbanking.service.impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import narif.lp.openbanking.model.Transaction;
import narif.lp.openbanking.repository.MerchantDetailsRepo;
import narif.lp.openbanking.repository.TransactionApiClient;
import narif.lp.openbanking.repository.TransactionRepo;
import narif.lp.openbanking.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepo transactionRepo;

    private final TransactionApiClient transactionApiClient;
    private final MerchantDetailsRepo merchantDetailsRepo;

    public TransactionServiceImpl(TransactionRepo transactionRepo, TransactionApiClient transactionApiClient, MerchantDetailsRepo merchantDetailsRepo) {
        this.transactionRepo = transactionRepo;
        this.transactionApiClient = transactionApiClient;
        this.merchantDetailsRepo = merchantDetailsRepo;
    }

    @CircuitBreaker(name = "transactionService", fallbackMethod = "foundNone")
    public List<Transaction> findAllByAccountNumber(final Long accountNumber) {
        var transactions = transactionApiClient.findAllByAccountNumber(accountNumber);
        transactions.forEach(transaction -> {
            merchantDetailsRepo
                    .findMerchantLogo(transaction.getMerchantName())
                    .ifPresent(logo ->
                            transaction.setMerchantLogo(logo)
                    );
        });

        return transactions;
    }

    private List<Transaction> foundNone(final Integer accountNumber, final Throwable throwable) {
        return Collections.emptyList();
    }


}
