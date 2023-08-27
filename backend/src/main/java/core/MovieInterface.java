package core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@SpringBootApplication(scanBasePackages = {"core.MediaRequestPackage", "core.api", "core.SQLEntities"})
@EnableAutoConfiguration
public class MovieInterface {
    public static void main(String args[]){
        SpringApplication.run(MovieInterface.class, args);
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/review/createReview").allowedOrigins("http://localhost:3000");
			}
		};
    }


}
