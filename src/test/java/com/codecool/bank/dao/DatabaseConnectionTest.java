package com.codecool.bank.dao;

import org.junit.jupiter.api.*;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {

    private DatabaseConnection dbConnector;

    @Test
    public void testOpenConnectionThrowsSQLException() throws SQLException {
        dbConnector = new DatabaseConnection("");
        assertThrows(SQLException.class, () -> dbConnector.openConnection());
    }

    @Test
    public void testGetConnectionReturnOpenConnection() throws SQLException {
        dbConnector = new DatabaseConnection("jdbc:sqlite:src/test/java/test_database.db");
        dbConnector.openConnection();
        assertFalse(dbConnector.getConnection().isClosed());
        dbConnector.closeConnection();
    }

    @Test
    public void testGetConnectionBeforeOpenConnectionReturnNull() {
        dbConnector = new DatabaseConnection("jdbc:sqlite:src/test/java/test_database.db");
        assertEquals(null, dbConnector.getConnection());
    }

    @Test
    public void testCloseConnectionClosingConnection() throws SQLException {
        dbConnector = new DatabaseConnection("jdbc:sqlite:src/test/java/test_database.db");
        dbConnector.openConnection();
        dbConnector.closeConnection();
        assertTrue(dbConnector.getConnection().isClosed());
    }

    @Nested
    @DisplayName("Database Tests")
    class databaseTests {

        @AfterEach
        public void dropTables() throws SQLException {
            dbConnector = new DatabaseConnection("jdbc:sqlite:src/test/java/test_database.db");
            dbConnector.openConnection();
            String dropTablesQuery = "DROP TABLE IF EXISTS `products`;" +
                    "DROP TABLE IF EXISTS `suppliers`;" +
                    "DROP TABLE IF EXISTS `product_categories`;";
            dbConnector.getConnection().createStatement().executeUpdate(dropTablesQuery);
            dbConnector.closeConnection();
            System.out.println("Boo");
        }

        @Test
        public void testMigrateDBCreateDBFile() throws SQLException {
            dbConnector = new DatabaseConnection("jdbc:sqlite:src/main/resources/database/codecool-bank.db");
            dbConnector.openConnection();
            dbConnector.migrateDb();
            List<String> tablesName = new ArrayList<>();
            DatabaseMetaData metaData = dbConnector.getConnection().getMetaData();
            ResultSet resultSet = metaData.getTables(null, null, "%", null);
            while (resultSet.next()) {
                tablesName.add(resultSet.getString(3));
            }
            assertTrue(tablesName.contains("Customers"));
            assertTrue(tablesName.contains("Accounts"));
            assertTrue(tablesName.contains("Cards"));
            assertTrue(tablesName.contains("Transactions"));
            assertTrue(tablesName.contains("TransactionTypes"));
            assertTrue(tablesName.contains("CardTypes"));
            assertTrue(tablesName.contains("TransactionStatuses"));
            assertTrue(tablesName.contains("AccountTypes"));
            assertTrue(tablesName.contains("AccountStatuses"));
            dbConnector.closeConnection();
        }
    }
}