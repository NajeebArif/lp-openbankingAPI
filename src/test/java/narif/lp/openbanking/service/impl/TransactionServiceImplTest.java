package narif.lp.openbanking.service.impl;

import narif.lp.openbanking.fixtures.TransactionFixtures;
import narif.lp.openbanking.model.Transaction;
import narif.lp.openbanking.repository.TransactionRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransactionServiceImplTest {

    public static final long ACCOUNT_NUMBER = 123456789l;
    private TransactionFixtures fixtures = new TransactionFixtures();
    private TransactionRepo transactionRepo;

    @BeforeEach
    public void init(){
        transactionRepo = Mockito.mock(TransactionRepo.class);
        when(transactionRepo.findAllByAccountNumber(ACCOUNT_NUMBER)).thenReturn(Arrays.asList(fixtures.getTransaction(ACCOUNT_NUMBER)));
    }

    @Test
    public void testNonEmptyListOfTransaction(){
        TransactionServiceImpl impl = new TransactionServiceImpl(transactionRepo);
        List<Transaction> allByAccountNumber = impl.findAllByAccountNumber(ACCOUNT_NUMBER);
        assertThat(allByAccountNumber)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1)
                .containsExactly(fixtures.getTransaction(ACCOUNT_NUMBER));
    }



}