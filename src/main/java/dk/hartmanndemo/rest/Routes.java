package dk.hartmanndemo.rest;

import dk.hartmanndemo.controllers.DogController;
import dk.hartmanndemo.dtos.DogDTO;
import dk.hartmanndemo.dtos.ErrorMessage;
import io.javalin.apibuilder.EndpointGroup;

import static io.javalin.apibuilder.ApiBuilder.*;

/**
 * Purpose:
 *
 * @author: Thomas Hartmann
 */
public class Routes {

    private static DogController dogController = new DogController();

    public static EndpointGroup getRoutes() {
        return () ->
        {
            path("dog", () -> {
                get("/", (ctx) -> ctx.json(dogController.getAll()));
//                           get("/demo", (ctx)->ctx.result("This is the demo endpoint"));
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
