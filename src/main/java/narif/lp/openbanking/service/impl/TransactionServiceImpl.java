package narif.lp.openbanking.service.impl;

import narif.lp.openbanking.model.Transaction;
import narif.lp.openbanking.service.TransactionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Override
    public List<Transaction> findAllByAccountNumber(Long accountNumber) {
        Transaction transaction = getTransaction(accountNumber);
        return Arrays.asList(transaction);
    }

    Transaction getTransaction(Long accountNumber) {
        Transaction transaction = new Transaction();
        transaction.setType(Transaction.Type.DEPOSIT_MONEY);
        transaction.setAccountNumber(accountNumber);
        transaction.setAmount(BigDecimal.valueOf(3000000));
        transaction.setCurrency("USD");
        transaction.setDate(Instant.now());
        transaction.setMerchantName("test");
        transaction.setMerchantLogo("/test.png");
        return transaction;
    }
}
