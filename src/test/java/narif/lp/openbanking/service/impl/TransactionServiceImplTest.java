package narif.lp.openbanking.service.impl;

import narif.lp.openbanking.model.Transaction;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class TransactionServiceImplTest {

    @Test
    public void testNonEmptyListOfTransaction(){
        TransactionServiceImpl impl = new TransactionServiceImpl();
        List<Transaction> allByAccountNumber = impl.findAllByAccountNumber(123456789l);
        assertThat(allByAccountNumber)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1)
                .containsExactly(impl.getTransaction(123456789l));
    }



}