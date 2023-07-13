package core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;


import core.api.APIRequestBuilder;
import core.api.keyHolder;

@SpringBootApplication
@EnableAutoConfiguration
public class MovieInterface {
    public static void main(String args[]){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("core.api");
        context.refresh();
        keyHolder key = context.getBean(keyHolder.class);
        System.out.println(key.getTest());
        SpringApplication.run(MovieInterface.class, args);
        

    }
   


}
