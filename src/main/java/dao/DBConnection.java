package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by mercutio on 07.06.17.
 */
public class DBConnection {

    java.sql.Connection connection;
    String path;

    public DBConnection(String path) {
        this.path = path;
    }

    public void openConnection() throws SQLException {
        connection = DriverManager.getConnection(this.path);
        System.out.println("Connection established...");
    }
}
