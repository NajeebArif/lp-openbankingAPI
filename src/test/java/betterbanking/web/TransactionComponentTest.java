package betterbanking.web;

import com.acme.banking.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.betterbanking.BetterBankingApplication;
import io.betterbanking.entity.Transaction;
import io.betterbanking.repository.InMemoryMerchantDetailsRepository;
import io.betterbanking.repository.RESTTransactionsAPIClient;
import io.betterbanking.repository.TransactionApiClient;
import io.betterbanking.repository.TransactionRepository;
import io.betterbanking.service.TransactionService;
import io.betterbanking.web.TransactionController;
import io.restassured.module.mockmvc.config.RestAssuredMockMvcConfig;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.config;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.config.MockMvcConfig.mockMvcConfig;
import static junit.framework.TestCase.assertEquals;

@SpringBootTest(classes = {BetterBankingApplication.class})
public class TransactionComponentTest {

    @LocalServerPort
    private int port;

    @MockBean
    private TransactionRepository transactionRepository;

    private MockWebServer server = new MockWebServer();
    private TransactionApiClient apiClient = new RESTTransactionsAPIClient(WebClient.create(server.url("/").toString()));
    private TransactionService transactionService = new TransactionService(apiClient, new InMemoryMerchantDetailsRepository(), transactionRepository);

    @Test
    @WithMockUser(username = "nbcrocker", password = "abc", roles = "read")
    public void testApplicationEndToEnd() throws Exception {
        var json = new ObjectMapper().writeValueAsString(transaction());
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .setBody(json));

        var t = Arrays.stream(
                given()
                        .config(noSecurity())
                        .standaloneSetup(new TransactionController(transactionService))
                        .when()
                        .get(String.format("http://localhost:%s/api/v1/transactions/1234567", port))
                        .then()
                        .extract()
                        .body()
                        .as(Transaction[].class))
                .findAny()
                .orElseThrow();

        assertEquals(100.0d, t.getAmount());
    }

    private OBReadTransaction6 transaction() {
        var t = new OBReadTransaction6();
        t.setData(new OBReadDataTransaction6());
        t.getData().addTransactionItem(transactions());
        return t;
    }

    private OBTransaction6 transactions() {
        var t = new OBTransaction6();
        t.setAccountId("1234567");
        t.setCreditDebitIndicator(OBCreditDebitCode1.DEBIT);
        t.setAmount(amount());
        t.setMerchantDetails(merchantDetails());
        return t;
    }

    private OBActiveOrHistoricCurrencyAndAmount9 amount() {
        var amount = new OBActiveOrHistoricCurrencyAndAmount9();
        amount.setAmount("100.00");
        amount.setCurrency("USD");
        return amount;
    }

    private OBMerchantDetails1 merchantDetails() {
        var m = new OBMerchantDetails1();
        m.setMerchantName("acme");
        m.setMerchantCategoryCode("25");
        return m;
    }

    private RestAssuredMockMvcConfig noSecurity() {
        return config().mockMvcConfig(mockMvcConfig()
                .dontAutomaticallyApplySpringSecurityMockMvcConfigurer());
    }
}