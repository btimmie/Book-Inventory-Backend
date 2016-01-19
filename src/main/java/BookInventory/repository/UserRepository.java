package BookInventory.repository;

import BookInventory.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Yongama on 2016/01/16.
 */
public interface UserRepository extends CrudRepository<User,Long> {
}
