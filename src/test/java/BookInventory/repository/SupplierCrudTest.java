/*
package BookInventory.repository;

import BookInventory.App;
import BookInventory.config.factory.SupplierFactory;
import BookInventory.domain.InventoryItem;
import BookInventory.domain.Supplier;
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

*/
/**
 * Created by student on 2015/05/03.
 *//*



@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class SupplierCrudTest extends AbstractTestNGSpringContextTests {
    private Long id;

    @Autowired
    private SupplierRepository repository;

    @Test
    public void create() throws Exception{
        List<InventoryItem> inventoryItemList = new ArrayList<>();
        Map<String,String> values = new HashMap<>();
        values.put("code", "22121");
        values.put("name","CNA");
        Supplier supplier = SupplierFactory
                .createSuplier(values, inventoryItemList);
        Assert.assertNotNull(supplier);
        //List<InventoryItem> inventoryItemList = new ArrayList<InventoryItem>();
        supplier = new Supplier.Builder("ABC")
        .name("Book world").address("45 Lower Main Road Observatory").build();

        repository.save(supplier);
        id=supplier.getId();
        Assert.assertNotNull(supplier.getId());
    }

    @Test(dependsOnMethods = "create")
    public void ReadTest() throws Exception{
        Supplier supplier =  repository.findOne(id);
        Assert.assertEquals("Book world",supplier.getName());
    }
    @Test(dependsOnMethods = "ReadTest")
    public void TestUpdate() throws Exception{
        Supplier supplier = repository.findOne(id);
        Supplier newSupplier = new Supplier.Builder("BBC").id(supplier.getId())
                .name("Book worldz").address("49 Loop Street Cape Town").build();
        repository.save(supplier);
        Assert.assertEquals("Book worldz",supplier.getName());
        Assert.assertEquals("49 Loop Street Cape Town",supplier.getAddress());
    }
    @Test(dependsOnMethods = "TestUpdate")
    public void dTestDelete() throws Exception{
        Supplier supplier = repository.findOne(id);
        repository.delete(supplier);
        Supplier newSupplier = repository.findOne(id);
        Assert.assertNull(newSupplier);
    }
}*/
