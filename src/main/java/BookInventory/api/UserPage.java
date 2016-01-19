package BookInventory.api;

import BookInventory.Services.UserService;
import BookInventory.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by Yongama on 2016/01/16.
 */
@RestController
@RequestMapping(value="/User/**")
public class UserPage {

    @Autowired
    private UserService service;
        //-------------------list all users--------------------------------------------------------
        @RequestMapping(value = "/userList/", method = RequestMethod.GET)
        public ResponseEntity<List<User>> listAllInventoryItems() {
            List<User> users = service.getUsers();
            if(users.isEmpty()){
                return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
            }
            return new ResponseEntity<List<User>>(users, HttpStatus.OK);
        }
            //-------------------Create a Book--------------------------------------------------------

        @RequestMapping(value = "/users/create", method = RequestMethod.POST)
        public ResponseEntity<Void> createBook(@RequestBody User user,    UriComponentsBuilder ucBuilder) {
            System.out.println("Creating User " + user.getFirstName());

    //     USE THIS IF YOU WANT TO CHECK UNIQUE OBJECT
    //      if (SubjectService.isSubjectExist(Subject)) {
    //            System.out.println("A Subject with name " + Subject.getName() + " already exist");
    //            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    //        }

        service.save(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a User --------------------------------------------------------

    @RequestMapping(value = "/user/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User Subject) {
        System.out.println("Updating User " + id);

        User currentUser = service.findById(id);

        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(Subject,HttpStatus.NOT_FOUND);
        }

        User updatedUser = new User
                .Builder(currentUser.getCode())
                .copy(currentUser)
                .build();
        service.update(updatedUser);
        return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
    }

}
