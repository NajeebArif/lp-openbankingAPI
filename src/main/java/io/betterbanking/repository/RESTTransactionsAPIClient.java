package io.betterbanking.repository;

import com.acme.banking.model.OBReadTransaction6;
import com.fasterxml.jackson.databind.JsonNode;
import io.betterbanking.adapters.acme.OBTransactionAdapter;
import io.betterbanking.entity.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.util.Base64Utils;
import org.springframework.web.reactive.function.BodyInserters;
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
        OBReadTransaction6 res = null;
        String encodedClientData =
                Base64Utils.encodeToString(String.format("%s:%s", clientId, secret).getBytes());
        try {
            res = client
                    .post()
                    .uri("/oauth/token")
                    .header("Authorization", "Basic " + encodedClientData)
                    .body(BodyInserters.fromFormData("grant_type", "client_credentials"))
                    .retrieve()
                    .bodyToMono(JsonNode.class)
                    .flatMap(tokenResponse -> {
                        String accessTokenValue = tokenResponse.get("access_token")
                                .textValue();
                        return client.get()
                                .uri("accounts/" + accountNumber + "/transactions")
                                .headers(h -> h.setBearerAuth(accessTokenValue))
                                .retrieve()
                                .bodyToMono(OBReadTransaction6.class);
                    })
                    .block();
        } catch (Exception ex) {
            log.error("failed to fetch account data from remote server due the following error {}", ex.getMessage());
        }

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

    @Value("${testnet.integration.client}")
    private String clientId;
    @Value("${testnet.integration.secret}")
    private String secret;
}
