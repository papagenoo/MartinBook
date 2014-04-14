package martinbook.ch34.gateway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by max on 15/04/14.
 */
public class DbProductGateway implements ProductGateway {

    private final Connection connection;

    public DbProductGateway(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Product product) throws Exception {
        String sql = "insert into Products (sku, name, price) " +
                     "values (?, ?, ?)";
        PreparedStatement command = connection.prepareStatement(sql);
        command.setString(1, product.getSku());
        command.setString(2, product.getName());
        command.setInt(3, product.getPrice());
        command.executeUpdate();
    }

    @Override
    public Product find(String sku) throws Exception {
        String sql = "select * from Products where sku = ?";
        PreparedStatement command = connection.prepareStatement(sql);
        command.setString(1, sku);
        ResultSet reader = command.executeQuery();
        Product product = null;
        if(reader.next()) {
            String name = reader.getString("name");
            int price = reader.getInt("price");
            product = new Product(name, sku, price);
        }
        reader.close();
        return product;
    }
}
