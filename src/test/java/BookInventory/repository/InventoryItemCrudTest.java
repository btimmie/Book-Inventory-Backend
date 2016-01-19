package BookInventory.repository;

import BookInventory.App;
import BookInventory.config.factory.InventoryItemFactory;
import BookInventory.domain.InventoryItem;
import BookInventory.domain.Supplier;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/05/03.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class InventoryItemCrudTest extends AbstractTestNGSpringContextTests {


    private Long id;

    @Autowired
    private InventoryRepository repository;

    @Test
    public void create() throws Exception{

        Map<String,String> values = new HashMap<String, String>();



        values.put("code","00789");
        values.put("name","Book");
        values.put("description","About a group of four intelligent individuals");

        InventoryItem inventoryItem = InventoryItemFactory
                .createInventoryItem(values,null);

        repository.save(inventoryItem);
        id=inventoryItem.getId();
        Assert.assertNotNull(inventoryItem);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception{
        InventoryItem inventoryItem = repository.findOne(id);
        Assert.assertNotNull(inventoryItem);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception{

        Supplier supplier = new Supplier.Builder("007").address("Obz").name("Yongz").build();
        InventoryItem inventoryItem = repository.findOne(id);

        InventoryItem newInventoryItem = new InventoryItem
                .Builder(inventoryItem.getCode())
                .copy(inventoryItem)
                .name("DVD")
                .supplier(supplier)
                .build();

        org.testng.Assert.assertEquals(newInventoryItem.getName(),"DVD");
        org.testng.Assert.assertEquals(inventoryItem.getName(),"Book");
        org.testng.Assert.assertNotNull(newInventoryItem.getSupplier());
    }
    @Test(dependsOnMethods = "update")
    public void delete() throws Exception{
        InventoryItem inventoryItem = repository.findOne(id);
        repository.delete(inventoryItem);
        InventoryItem newInventoryItem = repository.findOne(id);
        org.testng.Assert.assertNull(newInventoryItem);
    }

}
