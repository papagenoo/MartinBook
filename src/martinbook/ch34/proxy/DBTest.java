package martinbook.ch34.proxy;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by max on 11/04/14.
 */
public class DBTest {
    DB db;

    @Before
    public void setUp() {
        try {
            db = DB.getInstance();
            db.init();
        } catch (Throwable e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
    }

    @After
    public void tearDown() {
        try {
            db.close();
        } catch (Throwable e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void storeProduct() {
        try {
            ProductData storedProduct = new ProductData();
            storedProduct.name = "MyProduct";
            storedProduct.price = 1234;
            storedProduct.sku = "999";
            db.store(storedProduct);
            ProductData retrievedProduct = db.getProductData("999");
            db.deleteProductData("999");
            Assert.assertEquals(storedProduct, retrievedProduct);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
    }
}
