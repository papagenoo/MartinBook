package martinbook.ch34.gateway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by max on 15/04/14.
 */
public class DbOrderGateway implements OrderGateway {

    private final Connection connection;
    private final ProductGateway productGateway;

    public DbOrderGateway(Connection c, ProductGateway pg) {
        connection = c;
        productGateway = pg;
    }

    @Override
    public void insert(Order order) throws Exception {
        String sql = "insert into Orders (cusId) values ( ? )";
        PreparedStatement command = connection.prepareStatement(sql);
        command.setString(1, order.getCustomerId());
        int id = 0;
        command.executeUpdate();
        ResultSet rs = command.getGeneratedKeys();
        if (rs.next()) {
            id = rs.getInt("last_insert_rowid()");
        }
        order.setId(id);
        insertItems(order);
        connection.commit();
    }

    @Override
    public Order find(int id) throws Exception {
        String sql = "select * from Orders where orderId = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Order order = null;
        if (rs.next()) {
            String customerId = rs.getString("cusId");
            order = new Order(customerId);
            order.setId(id);
        }
        rs.close();
        if (order != null)
            LoadItems(order);
        return order;
    }

    private void LoadItems(Order order) throws Exception {
        String sql = "select * from Items where orderId = ?";
        PreparedStatement command = connection.prepareStatement(sql);
        command.setInt(1, order.getId());
        ResultSet reader = command.executeQuery();
        while (reader.next()) {
            String sku = reader.getString("sku");
            int quantity = reader.getInt("quantity");
            Product product = productGateway.find(sku);
            order.addItem(product, quantity);
        }
    }

    private void insertItems(Order order) throws Exception
    {
        String sql = "insert into Items (orderId, quantity, sku)" +
                     "values (?, ?, ?)";
        for (Item item : order.getItems()) {
            PreparedStatement command = connection.prepareStatement(sql);
            command.setInt(1, order.getId());
            command.setInt(2, item.getQuantity());
            command.setString(3, item.getProduct().getSku());
            command.executeUpdate();
        }
    }
}
