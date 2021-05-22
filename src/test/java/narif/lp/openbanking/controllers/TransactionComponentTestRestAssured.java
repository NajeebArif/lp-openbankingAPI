package narif.lp.openbanking.controllers;

import narif.lp.openbanking.fixtures.TransactionFixtures;
import narif.lp.openbanking.repository.TransactionRepo;
import narif.lp.openbanking.service.impl.TransactionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.Mockito.when;

/*
    These static imports should be done to autoconfigure RestAssured Mock Mvc.
    io.restassured.module.mockmvc.RestAssuredMockMvc.*
    io.restassured.module.mockmvc.matcher.RestAssuredMockMvcMatchers.*
*/
@ExtendWith(MockitoExtension.class)
class TransactionComponentTestRestAssured {

    public static final long ACCOUNT_NUMBER = 123456789l;
    private TransactionFixtures fixtures = new TransactionFixtures();
    private TransactionRepo transactionRepo;

    @BeforeEach
    public void init(){
        transactionRepo = Mockito.mock(TransactionRepo.class);
        when(transactionRepo.findAllByAccountNumber(ACCOUNT_NUMBER)).thenReturn(Arrays.asList(fixtures.getTransaction(ACCOUNT_NUMBER)));
    }


    @Test
    @DisplayName("Component Test for Transaction Controller")
    public void testTransactionComponent() {
        given()
                .standaloneSetup(new TransactionController(new TransactionServiceImpl(transactionRepo)))
        .when()
                .get("/transactions/{accountNumber}", 123456789l)
        .then()
                .statusCode(200);
    }

}