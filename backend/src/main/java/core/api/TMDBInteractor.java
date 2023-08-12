package core.api;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import org.springframework.http.MediaType;

import core.MediaRequestPackage.ActorIntro;
import core.MediaRequestPackage.ActorProfile;
import core.MediaRequestPackage.MovieCreditClass;
import core.MediaRequestPackage.MovieIDClass;
import core.MediaRequestPackage.MovieSubfolderPackage;
import core.MediaRequestPackage.SpecificActor;
import core.MediaRequestPackage.TVSeriesSubfolder;

public class TMDBInteractor {
    private APIRequestBuilder apiBuilder;
    private ObjectMapper mapper;
    private AnnotationConfigApplicationContext context;
    private keyHolder key;
    public TMDBInteractor(){
        this.apiBuilder = new APIRequestBuilder();
        this.mapper = new ObjectMapper();
        this.context = new AnnotationConfigApplicationContext();
    }
    public ArrayList<MovieSubfolderPackage> requestMovieByString(String title, String pageNum){
            ObjectMapper objectmapper = new ObjectMapper();
            String resourceURL = apiBuilder.movieSearchByWordTitle(title, pageNum);
            this.context.scan("core.api");
            this.context.refresh();
            this.key = this.context.getBean(keyHolder.class);

            WebClient client = WebClient.create(resourceURL);
            String responseVar = client.get()
            .header("Authorization", (" Bearer " + this.key.getKey())).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class).block();
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
    public MovieIDClass requestMovieByID(String id){
        ObjectMapper objectmapper = new ObjectMapper();
        String resourceURL = apiBuilder.movieSearchByID(id);
        this.context.scan("core.api");
        this.context.refresh();
        this.key = this.context.getBean(keyHolder.class);
        WebClient client = WebClient.create(resourceURL);
        String responseVar = client.get()
        .header("Authorization", (" Bearer " + this.key.getKey())).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class).block();
        try{
            JsonNode node = objectmapper.readTree(responseVar);
            MovieIDClass movie = new MovieIDClass(node);
            
            context.close();
            return movie;
        }
        catch (Exception e){
            System.out.println(e);
            context.close();
            return null;
        }
    }
    public ArrayList<ActorProfile> getActorByID(String ID){
        ObjectMapper objectmapper = new ObjectMapper();
        String resourceURL = apiBuilder.actorBuilderByID(ID);
        this.context.scan("core.api");
        this.context.refresh();
        this.key = this.context.getBean(keyHolder.class);
        WebClient client = WebClient.create(resourceURL);
        String responseVar = client.get()
        .header("Authorization", (" Bearer " + this.key.getKey())).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class).block();
        try{
            JsonNode node = objectmapper.readTree(responseVar);
            ArrayList<ActorProfile> actors = new ArrayList<ActorProfile>(15);
            if(node.get("cast").isArray()){
                for(JsonNode noodle : node.get("cast")){
                    actors.add(new ActorProfile(noodle));
                }
            }
            context.close();
            return actors;
        }
        catch (Exception e){
            System.out.println(e);
            context.close();
            return null;
        }
    }
    public ArrayList<MovieCreditClass> getMovieActor(String ID){
        ObjectMapper objectmapper = new ObjectMapper();
        String resourceURL = apiBuilder.MovieActorCreditByID(ID);
        this.context.scan("core.api");
        this.context.refresh();
        this.key = this.context.getBean(keyHolder.class);
        WebClient client = WebClient.create(resourceURL);
        String responseVar = client.get()
        .header("Authorization", (" Bearer " + this.key.getKey())).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class).block();
        try{
            JsonNode node = objectmapper.readTree(responseVar);
            ArrayList<MovieCreditClass> actors = new ArrayList<MovieCreditClass>(15);
            if(node.get("cast").isArray()){
                for(JsonNode noodle : node.get("cast")){
                    actors.add(new MovieCreditClass(noodle));
                }
            }
            context.close();
            return actors;
        }
        catch (Exception e){
            System.out.println(e);
            context.close();
            return null;
        }
    }
    public SpecificActor getSingleActor(String ID){
        ObjectMapper objectmapper = new ObjectMapper();
        String resourceURL = apiBuilder.actorSearchByID(ID);
        this.context.scan("core.api");
        this.context.refresh();
        this.key = this.context.getBean(keyHolder.class);
        WebClient client = WebClient.create(resourceURL);
        String responseVar = client.get()
        .header("Authorization", (" Bearer " + this.key.getKey())).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class).block();
        try{
            JsonNode node = objectmapper.readTree(responseVar);
            SpecificActor actor = new SpecificActor(node);
            
            context.close();
            return actor;
        }
        catch (Exception e){
            System.out.println(e);
            context.close();
            return null;
        }
    }
    public ArrayList<ActorIntro> listOfActors(String name){
        ObjectMapper objectmapper = new ObjectMapper();
        String resourceURL = apiBuilder.actorSearchByName(name);
        this.context.scan("core.api");
        this.context.refresh();
        this.key = this.context.getBean(keyHolder.class);
        WebClient client = WebClient.create(resourceURL);
        String responseVar = client.get()
        .header("Authorization", (" Bearer " + this.key.getKey())).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class).block();
        try{
            JsonNode node = objectmapper.readTree(responseVar);
            ArrayList<ActorIntro> actor = new ArrayList<ActorIntro>(100);
            if(node.get("results").isArray()){
                for(JsonNode noodle : node.get("results")){
                    actor.add(new ActorIntro(noodle));
                }
            }
            context.close();
            return actor;
        }
        catch (Exception e){
            System.out.println(e);
            context.close();
            return null;
        }
    } 
}
