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
        db = new DB();
        db.init();
    }

    @After
    public void tearDown() {
        db.close();
    }

    @Test
    public void storeProduct() {
//        ProductData storedProduct = new ProductData();
//        storedProduct.name = "MyProduct";
//        storedProduct.price = 1234;
//        storedProduct.sku = "999";
//        DB.store(storedProduct);
//        ProductData retrievedProduct =
//                DB.getProductData("999");
//        DB.deleteProductData("999");
//        Assert.assertEquals(storedProduct, retrievedProduct);
    }
}
