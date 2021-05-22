package narif.lp.openbanking.service.impl;

import narif.lp.openbanking.model.Transaction;
import narif.lp.openbanking.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TransactionServiceImplTest {

    public static final long ACCOUNT_NUMBER = 1234567;
    @Autowired
    private TransactionService transactionService;

    @BeforeEach
    public void init(){

    }

    @Test
    public void testNonEmptyListOfTransaction(){
        List<Transaction> allByAccountNumber = transactionService.findAllByAccountNumber(ACCOUNT_NUMBER);
        assertThat(allByAccountNumber)
                .isNotNull()
                .isNotEmpty()
                .hasSize(2);
    }



}