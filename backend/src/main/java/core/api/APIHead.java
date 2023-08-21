package core.api;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
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
import core.SQLEntities.Review;
import core.SQLEntities.ReviewRepo;
import core.SQLEntities.User;
import core.SQLEntities.UserRepo;
@RestController
@EnableAutoConfiguration
public class APIHead {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ReviewRepo reviewRepo;
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
       // TMDBInteractor interactor = new TMDBInteractor();
        
        
        
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
    @RequestMapping(value="movie/ByRecommendation")
    public ArrayList<MovieSubfolderPackage> moviesSimilarTo(@RequestHeader("name") String id){
        TMDBInteractor interactor = new TMDBInteractor();
        return interactor.movieByRecommendation(id);
    }
    @RequestMapping(value="AddUser")
    public void addUser(){
        User newUser = new User();
        newUser.setUsername("Staticzoop");
        userRepo.save(newUser);
    }
    @RequestMapping(value="DeleteUserByName")
    public boolean deleteUser(@RequestHeader("name") String name){
        return true;
    }
    @RequestMapping(value="createReview")
    public boolean createReview(@RequestHeader("id") Long authorID, @RequestHeader("mediaType") int mediaType, @RequestHeader("mediaID") Long mediaID){
        Review review = new Review();
        review.setAuthorID(authorID);
        review.setIdOfMedia(mediaID);
        review.setReviewType(mediaType);
        reviewRepo.save(review);
        return true;
    }
    @RequestMapping(value="reviewTest")
    public boolean checkReview(){
        Review review = new Review();
        review.setAuthorID(2);
        reviewRepo.save(review);
        return false;
    }
    @RequestMapping(value = "returnReviewsForSpecificMedia")
    public ArrayList<Review> returnReviewForMedia(@RequestHeader("id") Long mediaID, @RequestHeader("mediaType") int mediaType){
        ArrayList<Review> resultList = reviewRepo.getReviewsByMediaID(String.valueOf(mediaID), String.valueOf(mediaType));
        return resultList;
    }
    @RequestMapping(value = "returnReviewsMadeBySingleUser")
    public ArrayList<Review> returnUserCreatedReviews(@RequestHeader("userID") Long userID){
        ArrayList<Review> resultList = reviewRepo.getReviewsByAuthorID(String.valueOf(userID));
        return resultList;
    }
    @RequestMapping(value = "Empty")
    public String test(){
        return "What";
    }

}
