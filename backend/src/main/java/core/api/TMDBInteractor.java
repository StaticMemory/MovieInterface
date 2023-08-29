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
import core.MediaRequestPackage.TVEpisode;
import core.MediaRequestPackage.TVSeriesOverview;
import core.MediaRequestPackage.TVSeriesSubfolder;

public class TMDBInteractor {
    private APIRequestBuilder apiBuilder;
    private ObjectMapper objectmapper;
    private AnnotationConfigApplicationContext context;
    private keyHolder key;
    public TMDBInteractor(){
        this.apiBuilder = new APIRequestBuilder();
        this.objectmapper = new ObjectMapper();
        this.context = new AnnotationConfigApplicationContext(keyHolder.class);
        this.context.scan("core.api");
        this.key = this.context.getBean(keyHolder.class);

    }
    public ArrayList<MovieSubfolderPackage> requestMovieByString(String title, String pageNum){
            String resourceURL = apiBuilder.movieSearchByWordTitle(title, pageNum);
            
            WebClient client = WebClient.create(resourceURL);
            String responseVar = client.get()
            .header("Authorization", (" Bearer " + this.key.getKey())).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class).block();
            try{
                JsonNode node = this.objectmapper.readTree(responseVar);
                ArrayList<MovieSubfolderPackage> movies = new ArrayList<MovieSubfolderPackage>(100);
                if(node.get("results").isArray()){
                    for(JsonNode noodle : node.get("results")){
                        movies.add(new MovieSubfolderPackage(noodle));
                    }
                }
                this.context.close();
                movies.sort((o2,o1) -> Double.compare(o1.getPopularity(),o2.getPopularity()));
                return movies;
            }
            catch (Exception e){
                System.out.println(e);
                this.context.close();
                return null;
            }

        
    }
    public ArrayList<TVSeriesSubfolder> requestTVSeriesByString(String title, String pageNum){
        String resourceURL = apiBuilder.tvSearchByWordTitle(title, pageNum);

        WebClient client = WebClient.create(resourceURL);
        String responseVar = client.get()
        .header("Authorization", (" Bearer " + this.key.getKey())).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class).block();
        try{
            JsonNode node = this.objectmapper.readTree(responseVar);
            ArrayList<TVSeriesSubfolder> tvseries = new ArrayList<TVSeriesSubfolder>(100);
            if(node.get("results").isArray()){
                for(JsonNode noodle : node.get("results")){
                    tvseries.add(new TVSeriesSubfolder(noodle));
                }
            }
            this.context.close();
            return tvseries;
            }
        catch (Exception e){
            System.out.println(e);
            this.context.close();
            return null;
        }
    }
    public MovieIDClass requestMovieByID(String id){
        String resourceURL = apiBuilder.movieSearchByID(id);
        WebClient client = WebClient.create(resourceURL);
        String responseVar = client.get()
        .header("Authorization", (" Bearer " + this.key.getKey())).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class).block();
        try{
            JsonNode node = this.objectmapper.readTree(responseVar);
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
        String resourceURL = apiBuilder.actorBuilderByID(ID);
        WebClient client = WebClient.create(resourceURL);
        String responseVar = client.get()
        .header("Authorization", (" Bearer " + this.key.getKey())).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class).block();
        try{
            JsonNode node = this.objectmapper.readTree(responseVar);
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
        String resourceURL = apiBuilder.MovieActorCreditByID(ID);
        WebClient client = WebClient.create(resourceURL);
        String responseVar = client.get()
        .header("Authorization", (" Bearer " + this.key.getKey())).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class).block();
        try{
            JsonNode node = this.objectmapper.readTree(responseVar);
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
        String resourceURL = apiBuilder.actorSearchByID(ID);
        WebClient client = WebClient.create(resourceURL);
        String responseVar = client.get()
        .header("Authorization", (" Bearer " + this.key.getKey())).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class).block();
        try{
            JsonNode node = this.objectmapper.readTree(responseVar);
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
        String resourceURL = apiBuilder.actorSearchByName(name);
        WebClient client = WebClient.create(resourceURL);
        String responseVar = client.get()
        .header("Authorization", (" Bearer " + this.key.getKey())).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class).block();
        try{
            JsonNode node = this.objectmapper.readTree(responseVar);
            ArrayList<ActorIntro> actor = new ArrayList<ActorIntro>(100);
            if(node.get("results").isArray()){
                for(JsonNode noodle : node.get("results")){
                    actor.add(new ActorIntro(noodle));
                }
            }
            this.context.close();
            return actor;
        }
        catch (Exception e){
            System.out.println(e);
            this.context.close();
            return null;
        }
    }
    public ArrayList<MovieSubfolderPackage> movieByRecommendation(String ID){
        String resourceURL = apiBuilder.getMovieByRecommendation(ID);
        WebClient client = WebClient.create(resourceURL);
        String responseVar = client.get()
        .header("Authorization", (" Bearer " + this.key.getKey())).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class).block();
        try{
            JsonNode node = this.objectmapper.readTree(responseVar);
            ArrayList<MovieSubfolderPackage> movies = new ArrayList<MovieSubfolderPackage>(100);
            if(node.get("results").isArray()){
                for(JsonNode noodle : node.get("results")){
                    movies.add(new MovieSubfolderPackage(noodle));
                }
            }
            context.close();
            movies.sort((o2,o1) -> Double.compare(o1.getPopularity(),o2.getPopularity()));
            return movies;
        }
        catch (Exception e){
            System.out.println(e);
            context.close();
            return null;
        }
    }
    public ArrayList<TVEpisode> episodeList(String ID, String seasonNum){
        String resourceURL = apiBuilder.getEpisodeList(ID, seasonNum);
        WebClient client = WebClient.create(resourceURL);
        String responseVar = client.get()
        .header("Authorization", (" Bearer " + this.key.getKey())).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class).block();
        try{
            JsonNode node = this.objectmapper.readTree(responseVar);
            ArrayList<TVEpisode> seasons = new ArrayList<TVEpisode>(100);
            if(node.get("episodes").isArray()){
                for(JsonNode noodle : node.get("episodes")){
                    seasons.add(new TVEpisode(noodle));
                }
            }
            context.close();
            return seasons;
        }
        catch (Exception e){
            System.out.println(e);
            context.close();
            return null;
        }

    }
    public ArrayList<TVSeriesOverview> getSeriesOverview(String ID){
        String resourceURL = apiBuilder.getSeasonBreakdown(ID);
        WebClient client = WebClient.create(resourceURL);
        String responseVar = client.get()
        .header("Authorization", (" Bearer " + this.key.getKey())).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class).block();
        try{
            JsonNode node = this.objectmapper.readTree(responseVar);
            ArrayList<TVSeriesOverview> seasons = new ArrayList<TVSeriesOverview>(100);
            if(node.get("seasons").isArray()){
                for(JsonNode noodle : node.get("seasons")){
                    seasons.add(new TVSeriesOverview(noodle));
                }
            }
            context.close();
            return seasons;
        }
        catch (Exception e){
            System.out.println(e);
            context.close();
            return null;
        }
    } 
}
