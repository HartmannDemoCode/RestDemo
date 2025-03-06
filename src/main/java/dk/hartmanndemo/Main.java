package dk.hartmanndemo;

import dk.hartmanndemo.controllers.DogController;
import dk.hartmanndemo.dtos.DogDTO;
import dk.hartmanndemo.dtos.ErrorMessage;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Main {
    public static void main(String[] args){
        Javalin.create(config->{
            config.router.contextPath = "/api";
            config.router.apiBuilder().start(7070);
    }
}