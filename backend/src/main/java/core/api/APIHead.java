package core.api;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
import core.SQLEntities.ReviewData;
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
    @PostMapping(value="user/addUser")
    public void addUser(@RequestHeader("name") String name, @RequestHeader("image") String image){
        Optional<User> usr = userRepo.getUserByName(name);
        if(usr.isPresent()){
            return;
        }
        User newUser = new User();
        newUser.setUsername(name);
        newUser.setImage(image);
        userRepo.save(newUser);
    }
    @RequestMapping(value="user/deleteUserByName")
    public boolean deleteUser(@RequestHeader("name") String name){
        return true;
    }
    @PostMapping(value="review/createReview")
    public boolean createReview(@RequestHeader("id") String authorID, @RequestHeader("mediaType") String mediaType, 
    @RequestHeader("mediaID") String mediaID, @RequestHeader String rating, @RequestBody String reviewData){

        Review review = new Review();
        review.setAuthorID(Long.parseLong(authorID));
        review.setIdOfMedia(Long.parseLong(mediaID));
        review.setReviewType(Integer.parseInt(mediaType));
        review.setReviewData(reviewData);
        review.setReviewVal(Float.parseFloat(rating));
        reviewRepo.save(review);
        return true;

    }
    @RequestMapping(value = "media/returnSpecificMediaReview")
    public ArrayList<Review> returnReviewForMedia(@RequestHeader("id") String mediaID, @RequestHeader("mediaType") String mediaType){
        ArrayList<Review> resultList = reviewRepo.getReviewsByMediaID(Integer.parseInt(mediaType),Long.parseLong(mediaID));
        return resultList;
    }
    @RequestMapping(value = "user/returnReviewByUser")
    public ArrayList<Review> returnUserCreatedReviews(@RequestHeader("userID") String userID){
        ArrayList<Review> resultList = reviewRepo.getReviewsByAuthorID(userID);
        return resultList;
    }
    @RequestMapping(value = "user/returnUserByName")
    public Optional<User> returnUserByName(@RequestHeader("user") String name){
        Optional<User> usr = userRepo.getUserByName(name);
        return usr;
    }
    @RequestMapping(value = "review/deleteReview")
    public boolean deleteReview(@RequestHeader("reviewID") Long name){
        reviewRepo.deleteById(name);
        return true;
    }
    @RequestMapping(value = "user/returnUserByID")
    public Optional<User> returnUserByID(@RequestHeader("id") String ID){
        Optional<User> usr = userRepo.findById(Long.parseLong(ID));
        return usr;
    }
}
