package narif.lp.openbanking.repository;

import narif.lp.openbanking.model.Transaction;

import java.util.List;

public interface TransactionApiClient {

    List<Transaction> findAllByAccountNumber(final Long accountNumber);
}
