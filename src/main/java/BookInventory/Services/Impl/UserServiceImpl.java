package BookInventory.Services.Impl;

import BookInventory.Services.UserService;
import BookInventory.domain.User;
import BookInventory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yongama on 2016/01/16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> getUsers() {
        List<User> userList = new ArrayList<User>();
        Iterable<User> users = repository.findAll();
        for (User i : users) {
            userList.add(i);
        }
        return userList;
    }

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
}
