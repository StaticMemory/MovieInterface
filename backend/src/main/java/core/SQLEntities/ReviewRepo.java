package core.SQLEntities;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepo extends CrudRepository<Review,Long> {
    @Query("SELECT u FROM Review u WHERE u.authorID = ?1")
    ArrayList<Review> getReviewsByAuthorID(String id);

    @Query("SELECT u FROM Review u WHERE u.reviewType = ?1 and u.idOfMedia = ?2")
    ArrayList<Review> getReviewsByMediaID(String mediaType, String mediaID);


}
