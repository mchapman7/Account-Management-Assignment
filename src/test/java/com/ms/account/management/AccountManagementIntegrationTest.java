package com.ms.account.management;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AccountManagementIntegrationTest {

    @Test
    public void getAccountsByUSerId() {
        given().log().all()
                .when()
                .get("http://localhost:8080/api/v1/acctmgmt/users/2222/accounts")
                .then().log().all().statusCode(HttpStatus.OK.value());
    }

    @Test
    public void getTransactionsByUserIdAndAccountId() {
        given().log().all()
                .when()
                .get("http://localhost:8080/api/v1/acctmgmt/users/2222/accounts/121212/transactions")
                .then().log().all().statusCode(HttpStatus.OK.value());
    }
}
