package martinbook.ch34.proxy;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by max on 11/04/14.
 */
public class DB {
    private Connection connection;

    private DB() {

    }

    public void init() throws Exception {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:test.db");
        connection.setAutoCommit(false);
    }

    public void
    store(ProductData pd) throws Exception {
        PreparedStatement stmt = buildInsertionCommand(pd);
        stmt.executeUpdate();
        stmt.close();
        connection.commit();
    }

    private PreparedStatement
    buildInsertionCommand(ProductData pd) throws Exception {
        String sql = "INSERT INTO Products VALUES (?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, pd.sku);
        stmt.setString(2, pd.name);
        stmt.setInt(3, pd.price);
        return stmt;
    }

    public void
    close() throws Exception {
        connection.close();
    }

    public ProductData
    getProductData(String sku) throws Exception {
        PreparedStatement stmt = buildProductQueryCommand(sku);
        ResultSet rs = stmt.executeQuery();
        ProductData pd = extractProductDataFromReader(rs);
        rs.close();
        return pd;
    }

    private PreparedStatement
    buildProductQueryCommand(String sku) throws Exception {
        String sql = "SELECT * FROM Products WHERE sku = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, sku);
        return stmt;
    }

    private ProductData
    extractProductDataFromReader(ResultSet rs) throws Exception {
        ProductData pd = new ProductData();
        pd.sku = rs.getString("sku");
        pd.name = rs.getString("name");
        pd.price = rs.getInt("price");
        return pd;
    }

    public void
    deleteProductData(String sku) throws Exception {
        buildProductDeleteStatement(sku).execute();
    }

    private PreparedStatement
    buildProductDeleteStatement(String sku) throws Exception {
        String sql = "DELETE from Products WHERE sku = ? ";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, sku);
        return stmt;
    }

    private static ResultSet
    executeQueryStatement(PreparedStatement stmt) throws Exception {
        ResultSet rs = stmt.executeQuery();
        rs.next();
        return rs;
    }

    private static DB instance = new DB();

    public static DB getInstance() {
        return instance;
    }

    public OrderData newOrder(String customerId) throws Exception {
        String sql = "INSERT INTO Orders (cusId) VALUES( ? )";
        PreparedStatement command = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        command.setString(1, customerId);
        command.executeUpdate();
        ResultSet rs = command.getGeneratedKeys();
        int newOrderId;
        if (rs.next()) {
            newOrderId = rs.getInt(1);
            System.out.println(newOrderId);
        } else {
            throw new SQLException("Creating user failed, no generated key obtained.");
        }
        rs.close();
//        connection.commit();
        return newOrderId != 0 ? new OrderData(newOrderId, customerId) : null;
    }

    public void store(ItemData id) throws Exception
    {
        PreparedStatement command = buildItemInsersionStatement(id);
        command.executeUpdate();
    }

    private PreparedStatement
    buildItemInsersionStatement(ItemData id) throws Exception {
        String sql = "INSERT INTO Items(orderId, quantity, sku) " +
                     "VALUES (?, ?, ?)";
        PreparedStatement command = connection.prepareStatement(sql);
        command.setInt(1, id.orderId);
        command.setInt(2, id.qty);
        command.setString(3, id.sku);
        return command;
    }

    public ItemData[] getItemsForOrder(int orderId) throws Exception {
        PreparedStatement command =
                buildItemsForOrderQueryStatement(orderId);
        ResultSet reader = command.executeQuery();
        ItemData[] id = extractItemDataFromResultSet(reader);
        reader.close();
        return id;
    }

    private PreparedStatement
    buildItemsForOrderQueryStatement(int orderId) throws Exception {
        String sql = "SELECT * FROM Items " +
                     "WHERE orderid = ? ";
        PreparedStatement command = connection.prepareStatement(sql);
        command.setInt(1, orderId);
        return command;
    }

    private ItemData[]
    extractItemDataFromResultSet(ResultSet reader) throws Exception {
        ArrayList items = new ArrayList();
        while (reader.next())
        {
            int orderId = reader.getInt("orderId");
            int quantity = reader.getInt("quantity");
            String sku = reader.getString("sku");
            ItemData id = new ItemData(orderId, quantity, sku);
            items.add(id);
        }
        return (ItemData[])items.toArray(new ItemData[items.size()]);
    }

    public OrderData
    getOrderData(int orderId) throws Exception {
        String sql = "SELECT cusid FROM orders " +
                     "WHERE orderid = ? ";
        PreparedStatement command = connection.prepareStatement(sql);
        command.setInt(1, orderId);
        ResultSet reader = command.executeQuery();
        OrderData od = null;
        if (reader.next())
            od = new OrderData(orderId, reader.getString("cusid"));
        reader.close();
        return od;
    }

    public void
    clear() throws Exception {
        executeSql("DELETE FROM Items");
        executeSql("DELETE FROM Orders");
        executeSql("DELETE FROM Products");
    }

    private void
    executeSql(String sql) throws Exception {
        PreparedStatement command = connection.prepareStatement(sql);
        command.execute();
    }
}
