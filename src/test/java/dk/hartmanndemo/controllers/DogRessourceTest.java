package dk.hartmanndemo.controllers;

import dk.hartmanndemo.rest.ApplicationConfig;
import dk.hartmanndemo.rest.Routes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

class DogRessourceTest {

    @BeforeAll
    static void setupAll(){
        ApplicationConfig
                .getInstance()
                .initiateServer()
                .setRoute(Routes.getRoutes())
                .startServer(7777);
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
}