package pos.application.resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pos.javafx.application.resource.POSCart;
import pos.model.application.Item;
import pos.model.application.Price;
import pos.utils.TestUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/test-config.xml" })
public class POSCartTest {

    @Autowired
    private POSCart posCart;

    @Test
    public void testAdd() {
        String testType = "Test";

        Item testItem = TestUtils.createItem(testType, "", Price.nothing());
        Item testItem_copy = TestUtils.createItem(testType, "", Price.nothing());
        Item testItem2 = TestUtils.createItem(testType, "One", Price.nothing());

        posCart.add(testItem);
        posCart.add(testItem2);
        posCart.add(testItem_copy);
        posCart.add(testItem2);

        Assert.assertEquals(2, posCart.getItems().size());
    }

    @Test
    public void testRemove() {
        String testType = "Test";

        Item testItem = TestUtils.createItem(testType, "", Price.nothing());
        Item testItem2 = TestUtils.createItem(testType, "One", Price.nothing());

        posCart.add(testItem);
        posCart.add(testItem2);
        posCart.remove(testItem);

        Assert.assertFalse(posCart.hasItem(testItem));

        Assert.assertEquals(1, posCart.getItems().size());
    }

    @Test
    public void testIndexAt() {
        String testType = "Test";

        Item testItem = TestUtils.createItem(testType, "", Price.nothing());
        Item testItem_copy = TestUtils.createItem(testType, "", Price.nothing());
        Item testItem2 = TestUtils.createItem(testType, "One", Price.nothing());

        posCart.add(testItem);
        posCart.add(testItem2);

        Assert.assertEquals(0, posCart.indexAt(testItem));
        Assert.assertEquals(0, posCart.indexAt(testItem_copy));

        Assert.assertEquals(1, posCart.indexAt(testItem2));
    }

}