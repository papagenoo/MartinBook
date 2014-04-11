package martinbook.ch34.proxy;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by max on 11/04/14.
 */
public class DBTest {
    @Before
    public void setUp() {
        DB.Init();
    }

    @After
    public void tearDown() {
        DB.Close();
    }

    @Test
    public void storeProduct() {
        ProductData storedProduct = new ProductData();
        storedProduct.name = "MyProduct";
        storedProduct.price = 1234;
        storedProduct.sku = "999";
        DB.store(storedProduct);
        ProductData retrievedProduct =
                DB.getProductData("999");
        DB.deleteProductData("999");
        Assert.assertEquals(storedProduct, retrievedProduct);
    }
}
