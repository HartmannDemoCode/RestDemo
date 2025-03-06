package dk.hartmanndemo.rest;

import io.javalin.Javalin;
import io.javalin.apibuilder.EndpointGroup;
import io.javalin.config.JavalinConfig;

import static io.javalin.apibuilder.ApiBuilder.path;

/**
 * Purpose:
 *
 * @author: Thomas Hartmann
 */
public class ApplicationConfig {
    private static ApplicationConfig applicationConfig;
    private static Javalin app;
    private static JavalinConfig javalinConfig;
    private ApplicationConfig(){}

    public static ApplicationConfig getInstance(){
        if(applicationConfig == null){
            applicationConfig = new ApplicationConfig();
        }
        return applicationConfig;
    }

    public ApplicationConfig initiateServer(){
        app = Javalin.create(config -> {
            javalinConfig = config;
            config.http.defaultContentType = "application/json";
            config.router.contextPath = "/api";
            config.bundledPlugins.enableRouteOverview("/routes");
        });
        return applicationConfig;
    }
    public ApplicationConfig setRoute(EndpointGroup routes){
        javalinConfig.router.apiBuilder(()->{
            path("/", routes);
        });
        return applicationConfig;
    }
    public ApplicationConfig startServer(int port){
        app.start(port);
        return applicationConfig;
    }
}
