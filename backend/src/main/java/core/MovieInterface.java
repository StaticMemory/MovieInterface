package core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication(scanBasePackages = {"core.MediaRequestPackage", "core.api", "core.SQLEntities"})
@EnableAutoConfiguration
public class MovieInterface {
    public static void main(String args[]){
        SpringApplication.run(MovieInterface.class, args);
    }
   


}
