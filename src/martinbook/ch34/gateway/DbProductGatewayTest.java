package martinbook.ch34.gateway;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.PreparedStatement;

/**
 * Created by max on 15/04/14.
 */
public class DbProductGatewayTest extends AbstractDbGatewayTest {
    private DbProductGateway gateway;

    @Before
    public void SetUp() throws Exception {
        openConnection();
        gateway = new DbProductGateway(connection);
        executeSql("delete from Products");
    }

    @After
    public void TearDown() throws Exception {
        close();
    }

    @Test
    public void Insert() throws Exception {
        Product product = new Product("Peanut Butter", "pb", 3);
        gateway.insert(product);
        String sql = "select * from Products";
        PreparedStatement command =
                connection.prepareStatement(sql);
        reader = command.executeQuery();
        Assert.assertTrue(reader.next());
        Assert.assertEquals("pb", reader.getString("sku"));
        Assert.assertEquals("Peanut Butter", reader.getString("name"));
        Assert.assertEquals(3, reader.getInt("price"));
        Assert.assertFalse(reader.next());
    }

    @Test
    public void Find() throws Exception {
        Product pb = new Product("Peanut Butter", "pb", 3);
        Product jam = new Product("Strawberry Jam", "jam", 2);
        gateway.insert(pb);
        gateway.insert(jam);
        Assert.assertNull(gateway.find("bad sku"));
        Product foundPb = gateway.find(pb.getSku());
        CheckThatProductsMatch(pb, foundPb);
        Product foundJam = gateway.find(jam.getSku());
        CheckThatProductsMatch(jam, foundJam);
    }

    private static void
    CheckThatProductsMatch(Product pb, Product pb2) {
        Assert.assertEquals(pb.getName(), pb2.getName());
        Assert.assertEquals(pb.getSku(), pb2.getSku());
        Assert.assertEquals(pb.getPrice(), pb2.getPrice());
    }
}
