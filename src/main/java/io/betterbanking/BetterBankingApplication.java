package io.betterbanking;

import io.betterbanking.entity.Transaction;
import io.betterbanking.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Date;

@SpringBootApplication
public class BetterBankingApplication {
    public static void main(String[] args) {
        SpringApplication.run(BetterBankingApplication.class, args);
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    @Profile(value = "dev")
    @Bean
    public ApplicationRunner runner(final TransactionRepository repository) {
        return args -> {
            repository.deleteAll();
            var t = Transaction
                            .builder()
                            .type("Credit")
                            .date(new Date())
                            .accountNumber(1234567)
                            .currency("USD")
                            .amount(100.00)
                            .merchantName("Globex")
                            .merchantLogo("images/globex.png")
                            .build();
            repository.save(t);

            var t1 = Transaction
                    .builder()
                    .type("Debit")
                    .date(new Date())
                    .accountNumber(123456)
                    .currency("USD")
                    .amount(100.00)
                    .merchantName("Globex")
                    .merchantLogo("images/globex.png")
                    .build();
            repository.save(t1);
        };
    }

    @Value("${io.betterbanking.integration.url-base}")
    private String baseUrl;

}
