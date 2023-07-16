package core.api;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import org.springframework.http.MediaType;

import core.MediaRequestPackage.MovieSubfolderPackage;
import core.MediaRequestPackage.TVSeriesSubfolder;

public class TMDBInteractor {
    private APIRequestBuilder apiBuilder;
    public TMDBInteractor(){
        this.apiBuilder = new APIRequestBuilder();
    }
    public ArrayList<MovieSubfolderPackage> requestMovieByString(String title, String pageNum){
            ObjectMapper objectmapper = new ObjectMapper();
            String resourceURL = apiBuilder.movieSearchByWordTitle(title, pageNum);
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
            context.scan("core.api");
            context.refresh();
            keyHolder curKey = context.getBean(keyHolder.class);

            WebClient client = WebClient.create(resourceURL);
            String responseVar = client.get()
            .header("Authorization", (" Bearer " + curKey.getKey())).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class).block();
            try{
                JsonNode node = objectmapper.readTree(responseVar);
                ArrayList<MovieSubfolderPackage> movies = new ArrayList<MovieSubfolderPackage>(100);
                if(node.get("results").isArray()){
                    for(JsonNode noodle : node.get("results")){
                        movies.add(new MovieSubfolderPackage(noodle));
                    }
                }
                context.close();
                return movies;
            }
            catch (Exception e){
                System.out.println(e);
                context.close();
                return null;
            }

        
    }
    public ArrayList<TVSeriesSubfolder> requestTVSeriesByString(String title, String pageNum){
        ObjectMapper objectmapper = new ObjectMapper();
        String resourceURL = apiBuilder.tvSearchByWordTitle(title, pageNum);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("core.api");
        context.refresh();
        keyHolder curKey = context.getBean(keyHolder.class);

        WebClient client = WebClient.create(resourceURL);
        String responseVar = client.get()
        .header("Authorization", (" Bearer " + curKey.getKey())).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class).block();
        try{
            JsonNode node = objectmapper.readTree(responseVar);
            ArrayList<TVSeriesSubfolder> tvseries = new ArrayList<TVSeriesSubfolder>(100);
            if(node.get("results").isArray()){
                for(JsonNode noodle : node.get("results")){
                    tvseries.add(new TVSeriesSubfolder(noodle));
                }
            }
            context.close();
            return tvseries;
            }
        catch (Exception e){
            System.out.println(e);
            context.close();
            return null;
        }
    }
}
