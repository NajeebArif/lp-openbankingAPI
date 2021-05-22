package narif.lp.openbanking.controllers;

import narif.lp.openbanking.service.impl.TransactionServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

/*
    These static imports should be done to autoconfigure RestAssured Mock Mvc.
    io.restassured.module.mockmvc.RestAssuredMockMvc.*
    io.restassured.module.mockmvc.matcher.RestAssuredMockMvcMatchers.*
*/
class TransactionComponentTestRestAssured {

    @Test
    @DisplayName("Component Test for Transaction Controller")
    public void testTransactionComponent() {
        given()
                .standaloneSetup(new TransactionController(new TransactionServiceImpl()))
        .when()
                .get("/transactions/{accountNumber}", 123456789l)
        .then()
                .statusCode(200);
    }

}