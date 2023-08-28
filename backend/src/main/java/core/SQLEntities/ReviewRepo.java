package core.SQLEntities;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepo extends CrudRepository<Review,Long> {
    @Query("SELECT u FROM Review u WHERE u.authorID = ?1")
    ArrayList<Review> getReviewsByAuthorID(Long id);

    @Query("SELECT u FROM Review u WHERE u.reviewType = ?1 and u.idOfMedia = ?2")
    Optional<ArrayList<Review>> getReviewsByMediaID(int mediaType, Long mediaID);

    @Query("SELECT u FROM Review u WHERE u.reviewType = ?1 and u.idOfMedia =?2 and u.authorID = ?3")
    Optional<Review> checkIfReviewExists(int mediatype, Long mediaID, Long userID);

}
