package core.SQLEntities;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long>{
    @Query("SELECT u from User u WHERE u.username = ?1")
    Optional<User> getUserByName(String query);
    




}
