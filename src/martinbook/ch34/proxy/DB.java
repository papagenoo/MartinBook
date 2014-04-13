package martinbook.ch34.proxy;

import java.sql.*;

/**
 * Created by max on 11/04/14.
 */
public class DB {
    private Connection connection;

    public void init() throws Throwable {
        connection = null;
        Statement stmt = null;
//        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            connection.setAutoCommit(false);
//            System.out.println("Opened database successfully");
//
//            stmt = connection.createStatement();
//            String sql = "DELETE from COMPANY where ID=2;";
//            stmt.executeUpdate(sql);
//            connection.commit();

//            ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
//            while ( rs.next() ) {
//                int id = rs.getInt("id");
//                String  name = rs.getString("name");
//                int age  = rs.getInt("age");
//                String  address = rs.getString("address");
//                float salary = rs.getFloat("salary");
//                System.out.println( "ID = " + id );
//                System.out.println( "NAME = " + name );
//                System.out.println( "AGE = " + age );
//                System.out.println( "ADDRESS = " + address );
//                System.out.println( "SALARY = " + salary );
//                System.out.println();
//            }
//            rs.close();
//            stmt.close();
//            connection.close();
//        } catch ( Exception e ) {
//            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//            System.exit(0);
//        }
//        System.out.println("Operation done successfully");
    }

    public void store(ProductData pd) throws Throwable {
        PreparedStatement stmt = BuildInsertionCommand(pd);
        stmt.executeUpdate();
        stmt.close();
        connection.commit();
    }

    private PreparedStatement BuildInsertionCommand(ProductData pd) throws Throwable {
        String sql = "INSERT INTO Products VALUES (?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, pd.sku);
        stmt.setString(2, pd.name);
        stmt.setInt(3, pd.price);
        return stmt;
    }

    public void close() throws Throwable {
        connection.close();
    }

    public
    ProductData getProductData(String sku) throws Throwable {
        PreparedStatement command = BuildProductQueryCommand(sku);
        ResultSet rs = command.executeQuery();
        ProductData pd = ExtractProductDataFromReader(reader);
        rs.close();
        return pd;
    }

    private
    PreparedStatement BuildProductQueryCommand(String sku) throws Throwable {
        String sql = "SELECT * FROM Products WHERE sku = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, sku);
        return stmt;
    }
}
