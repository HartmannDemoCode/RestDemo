package dk.hartmanndemo;

import dk.hartmanndemo.controllers.DogController;
import dk.hartmanndemo.dtos.DogDTO;
import dk.hartmanndemo.dtos.ErrorMessage;
import dk.hartmanndemo.rest.Routes;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Main {
    public static void main(String[] args) {
        Javalin.create(config -> {
            config.router.contextPath = "/api";
            config.router.apiBuilder(Routes.getRoutes());
        }).start(7070);
    }
}