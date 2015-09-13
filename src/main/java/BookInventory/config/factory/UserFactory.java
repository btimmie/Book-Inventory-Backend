package BookInventory.config.factory;

import BookInventory.domain.User;

import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class UserFactory {
    public static User createCustomer(Map<String, String> values) {

        User user = new User
                .Builder(values.get("code"))
                .firstName(values.get("firstName"))
                .lastName(values.get("lastName"))
                //.consumtionList(consumtionList)
                .build();
        return user;
    }
}
