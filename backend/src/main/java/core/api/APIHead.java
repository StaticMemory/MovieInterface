package core.api;

import java.util.ArrayList;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import core.MediaRequestPackage.ActorIntro;
import core.MediaRequestPackage.ActorProfile;
import core.MediaRequestPackage.MovieCreditClass;
import core.MediaRequestPackage.MovieIDClass;
import core.MediaRequestPackage.MovieSubfolderPackage;
import core.MediaRequestPackage.SpecificActor;
import core.MediaRequestPackage.TVSeriesSubfolder;
@RestController
@EnableAutoConfiguration
public class APIHead {
    @RequestMapping(value="movie/BySearch")
    public ArrayList<MovieSubfolderPackage> returnBasicMovie (@RequestHeader("title") String title, @RequestHeader("page") String page){
        TMDBInteractor interactor = new TMDBInteractor();
        return interactor.requestMovieByString(title, page);
        
    }
    @RequestMapping(value="TV/BySearch")
    public ArrayList<TVSeriesSubfolder> returnBasicTVSeries(@RequestHeader("title") String title, @RequestHeader("page") String page){
        TMDBInteractor interactor = new TMDBInteractor();
        
        return interactor.requestTVSeriesByString(title, page);
    }
    @RequestMapping(value="tv/byID")
    public void getTVSplashPageInfo(@RequestHeader("id") String ID){
        TMDBInteractor interactor = new TMDBInteractor();
        
        
        
        return;
    }
    @RequestMapping(value="movie/byID")
    public MovieIDClass getMovieSplashPageInfo(@RequestHeader("id") String ID){
        TMDBInteractor interactor = new TMDBInteractor();
        return interactor.requestMovieByID(ID);
    }

    @RequestMapping(value="actor/SearchForMediaPage")
    public ArrayList<ActorProfile> getActorByIDForMediaPage(@RequestHeader("id") String ID){
        TMDBInteractor interactor = new TMDBInteractor();
        return interactor.getActorByID(ID);

    }
    @RequestMapping(value="actor/searchByIDMovieCredits")
    public ArrayList<MovieCreditClass> getMovieActorStarredIn(@RequestHeader("id") String ID){
        TMDBInteractor interactor = new TMDBInteractor();
        return interactor.getMovieActor(ID);
    }
    @RequestMapping(value="actor/getSingleActorByID")
    public SpecificActor getSingleActorByID(@RequestHeader("id") String id){
        TMDBInteractor interactor = new TMDBInteractor();
        return interactor.getSingleActor(id);
    }
    @RequestMapping(value="actor/bySearch")
    public ArrayList<ActorIntro> actorSearch(@RequestHeader("name") String name){
        TMDBInteractor interactor = new TMDBInteractor();
        return interactor.listOfActors(name);
    }
}
