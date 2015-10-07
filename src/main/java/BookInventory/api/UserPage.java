package BookInventory.api;

import BookInventory.Services.UserService;
import BookInventory.domain.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by student on 2015/09/22.
 */
@RestController
@RequestMapping(value="/api/**")
public class UserPage {

    @Autowired
    private UserService service;

//    @RequestMapping(value = "/supplier",method = RequestMethod.GET)
//    public Supplier getSupplier(){
//        Supplier supplier = new Supplier.Builder("ABC")
//                .name("Book world").address("45 Lower Main Road Observatory").build();
//        return supplier;
//    }

    //-------------------Retrieve All Users--------------------------------------------------------

    @RequestMapping(value = "/Users/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listUsers() {
        List<User> users = service.findAll();
        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }


    //-------------------Retrieve Single User--------------------------------------------------------

    @RequestMapping(value = "/User/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        User user = service.findById(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    //-------------------Create a User--------------------------------------------------------

    @RequestMapping(value = "/Supplier/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createSuppler(@RequestBody User user,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.getFirstName());


        service.save(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/supplier/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    //------------------- Update a User --------------------------------------------------------

    @RequestMapping(value = "/user/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
        System.out.println("Updating User " + id);

        User currentUser = service.findById(id);

        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);

        }

        User updatedUser = new User
                .Builder(currentUser.getCode())
                .copy(currentUser)
                .build();
        service.update(updatedUser);
        return new ResponseEntity<User>(updatedUser,HttpStatus.OK);
    }



    //------------------- Delete a User --------------------------------------------------------

    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteSubject(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting User with id " + id);

        User user = service.findById(id);
        if (user == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        service.delete(user);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
}
