package narif.lp.openbanking.repository;


import narif.lp.openbanking.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllByAccountNumber(Long accountNumber);
}
