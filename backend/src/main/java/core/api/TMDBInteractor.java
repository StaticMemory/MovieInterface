package core.api;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.MediaType;
import core.database.Movie;

public class TMDBInteractor {
    private APIRequestBuilder apiBuilder;
    public TMDBInteractor(){
        this.apiBuilder = new APIRequestBuilder();
    }
    public Movie requestMovieByString(String title){
        
            RestTemplate restTemplate = new RestTemplate();
            String resourceURL = apiBuilder.movieSearchByWordTitle(title);
            HttpHeaders headers = new HttpHeaders();
            
            headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
            headers.set("Authorization"," Bearer ");
            HttpEntity request = new HttpEntity<String>(resourceURL, headers);
            keyHolder curKey = new keyHolder();
            
            System.out.println(curKey.getTest());
            this.apiBuilder.movieSearchByWordTitle(title);
            return null;
        
    }
}
