package dao;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by mercutio on 07.06.17.
 */
class ConnectionTest {

    DBConnection testConnection;

    @Test
    public void testOpenConnectionThrowsSQLException() throws SQLException {
        testConnection = new DBConnection("");
        assertThrows(SQLException.class, () -> testConnection.openConnection());
    }

    @Test
    public void testGetConnectionReturnOpenConnection() throws SQLException {
        testConnection = new DBConnection("jdbc:sqlite:src/test/java/codecool-bank.db");
        testConnection.openConnection();
        assertFalse(testConnection.getConnection().isClosed());
        testConnection.closeConnection();
    }

}