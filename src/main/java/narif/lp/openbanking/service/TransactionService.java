package narif.lp.openbanking.service;

import narif.lp.openbanking.model.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> findAllByAccountNumber(Long accountNumber);
}
