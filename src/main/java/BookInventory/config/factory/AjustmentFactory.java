package BookInventory.config.factory;

import BookInventory.domain.Ajustment;

import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class AjustmentFactory {
    public static Ajustment createAjustment(int amount,Map<String,String> values){

        Ajustment ajustment = new Ajustment
                .Builder(values.get("code"))
                .amount(amount)
                //.employeeList(employeeList)
                .build();
        return ajustment;
    }
}
