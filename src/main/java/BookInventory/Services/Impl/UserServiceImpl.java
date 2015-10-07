package BookInventory.Services.Impl;

import BookInventory.Services.UserService;
import BookInventory.domain.User;
import BookInventory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/22.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public User save(User entity) {
        return repository.save(entity);
    }

    @Override
    public User update(User entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(User entity) {
        repository.delete(entity);
    }

    @Override
    public List<User> findAll() {
        List<User> allUsers = new ArrayList<User>();
        Iterable<User> users = repository.findAll();
        for(User user:users){
           allUsers.add(user);
        }
        return allUsers;
    }
}
