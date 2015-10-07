package BookInventory.repository;

import BookInventory.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/09/22.
 */
public interface UserRepository extends CrudRepository<User,Long> {
}
