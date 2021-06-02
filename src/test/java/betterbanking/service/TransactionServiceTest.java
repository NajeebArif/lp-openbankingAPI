package betterbanking.service;

import io.betterbanking.BetterBankingApplication;
import io.betterbanking.entity.Transaction;
import io.betterbanking.repository.MerchantDetailsRepository;
import io.betterbanking.repository.TransactionApiClient;
import io.betterbanking.service.TransactionService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {BetterBankingApplication.class})
public class TransactionServiceTest {

    @Mock private TransactionApiClient transactionApiClient;
    @Mock private MerchantDetailsRepository merchantDetailsRepository;
    @InjectMocks private TransactionService transactionService;

    @DisplayName("test TransactionService with mock TransactionApiClient")
    @Test
    public void testTransactionCount() throws Exception {
        when(transactionApiClient.findAllByAccountNumber(any()))
                .thenReturn(List.of(new Transaction()));

        assertEquals(1, transactionService.findAllByAccountNumber(1234567).size());
    }
}