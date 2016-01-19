package BookInventory.Services;

import BookInventory.domain.User;

import java.util.List;

/**
 * Created by Yongama on 2016/01/16.
 */
public interface UserService {

    List<User> getUsers();

    User findById(Long id);

    User save(User entity);

    User update(User entity);

    void delete(User entity);
}
