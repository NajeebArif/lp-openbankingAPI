package io.betterbanking.repository;

import com.acme.banking.model.OBReadTransaction6;
import io.betterbanking.adapters.acme.OBTransactionAdapter;
import io.betterbanking.entity.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@Repository
public class RESTTransactionsAPIClient implements TransactionApiClient {

    @Autowired
    public RESTTransactionsAPIClient(final WebClient client) {
        this.client = client;
    }

    @Override
    public List<Transaction> findAllByAccountNumber(final Integer accountNumber) {
        OBReadTransaction6 res = client.get()
                    .uri("accounts/" + accountNumber + "/transactions")
                    .retrieve()
                    .bodyToMono(OBReadTransaction6.class)
                    .block()
            ;

        if (res == null || res.getData() == null) {
            return Collections.emptyList();
        }

        return res.getData()
                .getTransaction()
                .stream()
                .map(adapter::adapt)
                .collect(toList());
    }

    private final WebClient client;
    private final OBTransactionAdapter adapter = new OBTransactionAdapter();
}
