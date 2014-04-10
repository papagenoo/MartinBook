package martinbook.ch34.proxy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 10.04.14
 * Time: 20:13
 * To change this template use File | Settings | File Templates.
 */
public class TestOrderPrice {
    @Test
    public void TestOrderPrice() {
        Order o = new Order("Bob");
        Product toothpaste = new Product("Toothpaste", 129);
        o.addItem(toothpaste, 1);
        Assert.assertEquals(129, o.getTotal());
        Product mouthwash = new Product("Mouthwash", 342);
        o.addItem(mouthwash, 2);
        Assert.assertEquals(813, o.getTotal());
    }
}
