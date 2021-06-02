package narif.lp.openbanking.repository.impl;

import com.acme.banking.model.OBReadTransaction6;
import lombok.extern.slf4j.Slf4j;
import narif.lp.openbanking.adapters.OBTransactionAdapter;
import narif.lp.openbanking.model.Transaction;
import narif.lp.openbanking.repository.TransactionApiClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@Repository
public class RESTTransactionsAPIClient implements TransactionApiClient {

    private final WebClient client;
    private final OBTransactionAdapter adapter = new OBTransactionAdapter();


    public RESTTransactionsAPIClient(WebClient client) {
        this.client = client;
    }

    @Override
    public List<Transaction> findAllByAccountNumber(Long accountNumber) {
        OBReadTransaction6 res = null;

        try {
            res = client.get()
                    .uri("accounts/" + accountNumber + "/transactions")
                    .retrieve()
                    .bodyToMono(OBReadTransaction6.class)
                    .block()
            ;
        } catch (Exception ex) {
            log.error("failed to retrieve account information due to the following reason {}", ex.getMessage());
        }

        if (res == null || res.getData() == null) {
            return Collections.emptyList();
        }

        return res.getData()
                .getTransaction()
                .stream()
                .map(adapter::mapToTransaction)
                .collect(toList());
    }
}
