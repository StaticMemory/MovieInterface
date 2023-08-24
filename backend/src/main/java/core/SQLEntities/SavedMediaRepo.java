package core.SQLEntities;

import org.springframework.data.repository.CrudRepository;

public interface SavedMediaRepo extends CrudRepository<savedMediaByUser, Long> {
    
}
