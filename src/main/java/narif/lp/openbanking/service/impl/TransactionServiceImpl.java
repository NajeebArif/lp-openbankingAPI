package narif.lp.openbanking.service.impl;

import narif.lp.openbanking.model.Transaction;
import narif.lp.openbanking.repository.TransactionRepo;
import narif.lp.openbanking.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepo transactionRepo;

    public TransactionServiceImpl(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    @Override
    public List<Transaction> findAllByAccountNumber(Long accountNumber) {
        return transactionRepo.findAllByAccountNumber(accountNumber);
    }


}
