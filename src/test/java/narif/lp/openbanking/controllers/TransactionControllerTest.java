package narif.lp.openbanking.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransactionControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testController(){
        ResponseEntity<String> forEntity = restTemplate.getForEntity("/transactions/123456789", String.class);
        assertThat(forEntity.getStatusCodeValue()).isEqualTo(200);
    }
}
