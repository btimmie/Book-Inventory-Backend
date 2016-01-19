package BookInventory.domain;
/*
import BookInventory.config.factory.ReturnFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReturnTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void createReturn() throws Exception{
        List<User> userList = new ArrayList<User>();
        Map<String,String> values = new HashMap<String,String>();

        values.put("code","54ZTY");

        Return ret = ReturnFactory
                .createReturn(5, values);

        Assert.assertEquals("54ZTY", ret.getCode());
    }

    @Test
    public void updateReturn() throws Exception {
        List<User> userList = new ArrayList<User>();
        Map<String, String> values = new HashMap<String, String>();

        values.put("code", "54ZTY");

        Return ret = ReturnFactory
                .createReturn(5, values);

        Return newReturn = new Return
                .Builder(ret.getCode())
                .quantity(4)
                .build();

        Assert.assertEquals("54ZTY",ret.getCode());
        Assert.assertEquals("54ZTY", newReturn.getCode());
        Assert.assertEquals(5,ret.getQuantity());
        Assert.assertEquals(4,newReturn.getQuantity());
    }
}*/