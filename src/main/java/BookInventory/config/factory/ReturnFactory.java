package BookInventory.config.factory;

import BookInventory.domain.Return;

import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class ReturnFactory {
    public static Return createReturn(int quantity, Map<String,String> values){

        Return ret = new Return
                .Builder(values.get("code"))
                .quantity(quantity)
                //.customerList(userList)
                .build();
        return ret;
    }
}
