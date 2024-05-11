package dev.srujan.springfirstproject;

import dev.srujan.springfirstproject.controllers.ProductController;
import dev.srujan.springfirstproject.services.FakeStoreProductService;
import dev.srujan.springfirstproject.services.ProductService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstApi {




    @RequestMapping("/hello")
    public String sayHello(){
        return "hello";
    }

    @RequestMapping("/bye")
    public String sayBye(){
        return "Bye";
    }

    @RequestMapping("/hello/{nameCommingFromUrl}")
    public String sayHellotoSomeone(@PathVariable("nameCommingFromUrl") String nameOfSomeOne){
        return "hello " + nameOfSomeOne;
    }
}

/*
 if we have a class which has some methods that has to be called from server, which should be annotated with @RestController

 we want to map this method to certain url/end point that should be annotated with @RequestMapping("/hello")

 we can mention the port in resources/application.properties , "server.port = 8080"
 */