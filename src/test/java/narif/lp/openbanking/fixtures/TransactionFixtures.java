package narif.lp.openbanking.fixtures;

import narif.lp.openbanking.model.Transaction;

import java.math.BigDecimal;
import java.time.Instant;

public class TransactionFixtures {

    public Transaction getTransaction(Long accountNumber) {
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
