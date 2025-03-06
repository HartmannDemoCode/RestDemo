package dk.hartmanndemo.controllers;

import dk.hartmanndemo.rest.ApplicationConfig;
import dk.hartmanndemo.rest.Routes;
import io.restassured.RestAssured;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class DogRessourceTest {

    @BeforeAll
    static void setupAll(){
        ApplicationConfig
                .getInstance()
                .initiateServer()
                .setRoute(Routes.getRoutes())
                .startServer(7777);
        RestAssured.baseURI = "http://localhost:7777/api";
    }

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Test getting dog by id")
    void dogByIdTest(){
        given()
                .when()
                .get("/dog/3")
                .then()
                .statusCode(200)
                .body("id", equalTo(3));
    }
}