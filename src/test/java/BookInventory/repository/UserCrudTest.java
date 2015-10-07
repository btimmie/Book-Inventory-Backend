package BookInventory.repository;

import BookInventory.App;
import BookInventory.config.factory.UserFactory;
import BookInventory.domain.Consumtion;
import BookInventory.domain.User;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/05/03.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class UserCrudTest extends AbstractTestNGSpringContextTests {
    private Long id;

    @Autowired
    private UserRepository repository;

    @Test
    public void create() throws Exception{
        //List<Consumtion> consumtionList = new ArrayList<Consumtion>();
        Map<String,String> values = new HashMap<String,String>();

        values.put("code","5478");
        values.put("firstName","Junaid");
        values.put("lastName","Duplessis");
        //values.put("password","123");

        User user = UserFactory
                .createCustomer(values);

        repository.save(user);
        id= user.getId();
        Assert.assertNotNull(user);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception{
        User user = repository.findOne(id);
        Assert.assertNotNull(user);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception{
        List<Consumtion> consumtionList = new ArrayList<Consumtion>();
        Map<String, String> values = new HashMap<String, String>();

        values.put("code", "98TYT");
        values.put("firstName","Lexi");
        values.put("lastName","Parker");
        //values.put("password","123");


        User user = UserFactory
                .createCustomer(values);

        User newUser = new User
                .Builder(user.getCode())
                .firstName("Audrey")
                .lastName("Parker")
                .build();

        User updateUser = repository.findOne(id);
        org.testng.Assert.assertEquals(updateUser.getLastName(),"Queen");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception{
        User user = repository.findOne(id);
        repository.delete(user);
        User deletedUser = repository.findOne(id);
        org.testng.Assert.assertNull(deletedUser);
    }
}
