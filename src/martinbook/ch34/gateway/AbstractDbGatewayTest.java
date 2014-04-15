package martinbook.ch34.gateway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by max on 15/04/14.
 */
public abstract class AbstractDbGatewayTest {
    protected Connection connection;
    protected DbProductGateway gateway;
    protected ResultSet reader;

    protected void executeSql(String sql) throws Exception {
        PreparedStatement command = connection.prepareStatement(sql);
        command.execute();
    }

    protected void openConnection() throws Exception {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:test.db");
        connection.setAutoCommit(false);
    }

    protected void close() throws Exception {
        if(reader != null)
            reader.close();
        if(connection != null)
            connection.close();
    }
}
