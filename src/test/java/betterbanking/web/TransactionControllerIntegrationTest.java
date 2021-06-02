package betterbanking.web;

import io.betterbanking.BetterBankingApplication;
import io.betterbanking.entity.Transaction;
import io.betterbanking.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(classes = BetterBankingApplication.class)
public class TransactionControllerIntegrationTest {

    private static final String CLIENT_ID = "open-banking";
    private static final String CLIENT_SECRET = "1b206e8f-120a-4735-a371-faf573c21df7";

    @MockBean
    private TransactionService transactionService;

    @Test
    public void testUnauthenticatedTransactions() throws Exception {
        doReturn(List.of(new Transaction())).when(transactionService).findAllByAccountNumber(anyInt());

        mockMvc.perform(
                get("/api/v1/transactions/123456"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    public void testAuthenticatedTransactions() throws Exception {
        String accessToken = obtainAccessToken("nbcrocker", "abc");

        mockMvc.perform(get("/api/v1/transactions/123456")
                .header("Authorization", "Bearer " + accessToken)
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(status().is2xxSuccessful());
    }

    private String obtainAccessToken(String username, String password) throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "password");
        params.add("client_id", CLIENT_ID);
        params.add("client_secret", CLIENT_SECRET);
        params.add("username", username);
        params.add("password", password);

        var webClient = WebClient.create("http://localhost:9001");
        var resultString = webClient.post()
                .uri("/auth/realms/master/protocol/openid-connect/token")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData(params))
                .retrieve()
                .bodyToMono(String.class)
                .block();

//        ResultActions result
//                = mockMvc.perform(post("http://localhost:9001/auth/realms/master/protocol/openid-connect/token")
//                .params(params)
//                .with(httpBasic(CLIENT_ID, CLIENT_SECRET))
//                .accept("application/json;charset=UTF-8"))
//                //.andExpect(status().isOk())
//                .andExpect(content().contentType("application/json;charset=UTF-8"));
//
//        String resultString = result.andReturn().getResponse().getContentAsString();

        JacksonJsonParser jsonParser = new JacksonJsonParser();
        return jsonParser.parseMap(resultString).get("access_token").toString();
    }

    @Autowired
    private MockMvc mockMvc;
}