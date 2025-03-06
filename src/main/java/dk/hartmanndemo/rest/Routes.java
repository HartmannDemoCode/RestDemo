package dk.hartmanndemo.rest;

import dk.hartmanndemo.controllers.DogController;
import dk.hartmanndemo.dtos.DogDTO;
import dk.hartmanndemo.dtos.ErrorMessage;
import io.javalin.apibuilder.EndpointGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.javalin.apibuilder.ApiBuilder.*;

/**
 * Purpose:
 *
 * @author: Thomas Hartmann
 */
public class Routes {

    private static DogController dogController = new DogController();

    private static Logger logger = LoggerFactory.getLogger(Routes.class);

    public static EndpointGroup getRoutes() {
        return () ->
        {
            path("dog", () -> {
                get("/", (ctx) -> {
                    logger.info("Dette er noget info om hvilken ressource brugeren har tilgået: "+ctx.path());
                    ctx.json(dogController.getAll());
                });
                get("/{id}", (ctx) -> {
                    try {
                        DogDTO dog = dogController.getById(Integer.parseInt(ctx.pathParam("id")));
                        ctx.json(dog);

                    } catch (Exception ex) {
                        ErrorMessage error = new ErrorMessage("No dog with that id");
                        ctx.status(404).json(error);
                    }

                });
                post("/", (ctx) -> {
                    DogDTO incomingDog = ctx.bodyAsClass(DogDTO.class);
                    DogDTO returnedDog = dogController.create(incomingDog);
                    ctx.json(returnedDog);
                });
//                           put("/{id}", (ctx)->{
//                               int id = Integer.parseInt(ctx.pathParam("id"));
//                               DogDTO incomingDog = ctx.bodyAsClass(DogDTO.class);
//                               for(int i = 0; i<dogs.size(); i++){
//                                   if(dogs.get(i).getId() == id){
//                                       incomingDog.setId(id);
//                                       dogs.set(i, incomingDog);
//                                   }
//                               }
//                               ctx.json(dogs.get(id-1));
//                           });
            });
        };
    }
}
