package martinbook.ch34.proxy;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 14.04.14
 * Time: 17:20
 * To change this template use File | Settings | File Templates.
 */
public class ProxyTest {
    /*DB db;

    @Before
    public void setUp()
    {
        try {
            db = DB.getInstance();
            db.init();
            ProductData pd = new ProductData();
            pd.sku = "ProxyTest1";
            pd.name = "ProxyTestName1";
            pd.price = 456;
            db.store(pd);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
    }

    @After
    public void tearDown()
    {
        try {
            db.deleteProductData("ProxyTest1");
            db.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
    }
    @Test
    public void productProxy()
    {
        try {
            Product p = new ProductProxy("ProxyTest1");
            Assert.assertEquals(456, p.getPrice());
            Assert.assertEquals("ProxyTestName1", p.getName());
            Assert.assertEquals("ProxyTest1", p.getSku());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
    }
    @Test
    public void orderProxyTotal()
    {
//        try {
//            db.store(new ProductData("Wheaties", 349, "wheaties"));
//            db.store(new ProductData("Crest", 258, "crest"));
//            ProductProxy wheaties = new ProductProxy("wheaties");
//            ProductProxy crest = new ProductProxy("crest");
//            OrderData od = db.newOrder("testOrderProxy");
//            OrderProxy order = new OrderProxy(od.orderId);
////        order.AddItem(crest, 1);
////        order.AddItem(wheaties, 2);
////        Assert.AreEqual(956, order.Total);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            Assert.fail();
//        }
    }

    @Test
    public void orderKeyGeneration() {
        try {
            OrderData o1 = db.newOrder("Bob");
            OrderData o2 = db.newOrder("Bill");
           int firstOrderId = o1.orderId;
          int secondOrderId = o2.orderId;
          Assert.assertEquals(firstOrderId + 1, secondOrderId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
    }


    @Test
    public void storeItem()
    {
        try {
            ItemData storedItem = new ItemData(1, 3, "sku");
            db.store(storedItem);
            ItemData[] retrievedItems = db.getItemsForOrder(1);
            Assert.assertEquals(1, retrievedItems.length);
            Assert.assertEquals(storedItem, retrievedItems[0]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
    }
    @Test
    public void noItems()
    {
        try {
            ItemData[] id = db.getItemsForOrder(42);
            Assert.assertEquals(0, id.length);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
    }*/
}
