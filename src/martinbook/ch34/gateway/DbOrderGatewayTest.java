package martinbook.ch34.gateway;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by max on 15/04/14.
 */
public class DbOrderGatewayTest extends AbstractDbGatewayTest {
    private DbOrderGateway gateway;
    private Product pizza;
    private Product beer;
    @Before
    public void SetUp() throws Exception
    {
        openConnection();
        pizza = new Product("Pizza", "pizza", 15);
        beer = new Product("Beer", "beer", 2);
        ProductGateway productGateway =
                new InMemoryProductGateway();
        productGateway.insert(pizza);
        productGateway.insert(beer);
        gateway = new DbOrderGateway(connection, productGateway);
        executeSql("delete from Orders");
        executeSql("delete from Items");
    }

    @After
    public void TearDown() throws Exception
    {
        close();
    }
    @Test
    public void Find() throws Exception
    {
        // create table t(orderId integer primary key autoincrement, cusId)
        String sql = "insert into Orders (cusId) values ('Snoopy')";
        PreparedStatement command = connection.prepareStatement(sql);
        int orderId = 0;
        command.executeUpdate();
        // todo: Переделать везде!
        ResultSet rs = command.getGeneratedKeys();
        if (rs.next()) {
            orderId = rs.getInt("last_insert_rowid()");
        }
        executeSql(String.format("insert into Items (orderId, " +
                "quantity, sku) values (%d, 1, 'pizza')", orderId));
        executeSql(String.format("insert into Items (orderId, " +
                "quantity, sku) values (%d, 6, 'beer')", orderId));
        Order order = gateway.find(orderId);
        Assert.assertEquals("Snoopy", order.getCustomerId());
        Assert.assertEquals(2, order.getItemCount());
        Assert.assertEquals(1, order.quantityOf(pizza));
        Assert.assertEquals(6, order.quantityOf(beer));
        //connection.commit();
    }
    @Test
    public void Insert() throws Exception
    {
        Order order = new Order("Snoopy");
        order.addItem(pizza, 1);
        order.addItem(beer, 6);
        gateway.insert(order);
        Assert.assertTrue(order.getId() != -1);
        Order foundOrder = gateway.find(order.getId());
        Assert.assertEquals("Snoopy", foundOrder.getCustomerId());
        Assert.assertEquals(2, foundOrder.getItemCount());
        Assert.assertEquals(1, foundOrder.quantityOf(pizza));
        Assert.assertEquals(6, foundOrder.quantityOf(beer));
    }
}
