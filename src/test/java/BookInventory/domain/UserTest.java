package BookInventory.domain;

import BookInventory.config.factory.UserFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserTest {

    @Before
    public void setUp() throws Exception {

    }
    @Test
    public void createCustomer() throws ExportException{
        List<Consumtion> consumtionList = new ArrayList<Consumtion>();
        Map<String,String> values = new HashMap<String,String>();

        values.put("code","98TYT");

        User user = UserFactory
                .createCustomer(values);

        Assert.assertEquals("98TYT", user.getCode());
    }

    @Test
    public void updateCustomer() throws ExportException {
        List<Consumtion> consumtionList = new ArrayList<Consumtion>();
        Map<String, String> values = new HashMap<String, String>();

        values.put("code", "98TYT");
        values.put("firstName","Lexi");
        values.put("lastName","Parker");

        User user = UserFactory
                .createCustomer(values);

        User newUser = new User
                .Builder(user.getCode())
                .firstName("Audrey")
                .lastName("Parker")
                .build();

        Assert.assertEquals("Parker", user.getLastName());
        Assert.assertEquals("Parker", newUser.getLastName());
        Assert.assertEquals("Lexi", user.getFirstName());
        Assert.assertEquals("Audrey", newUser.getFirstName());
    }
}