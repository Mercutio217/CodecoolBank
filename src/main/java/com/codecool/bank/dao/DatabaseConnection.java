package com.codecool.bank.dao;

import com.codecool.bank.utils.FileReader;
import java.sql.*;


public final class DatabaseConnection {
    private Connection connection;
    private FileReader reader;
    private String pathToDatabase;

    public DatabaseConnection(String pathToDatabase) {
        this.reader =  new FileReader();
        this.pathToDatabase = pathToDatabase;
    }

    public void openConnection() throws SQLException {
        connection = DriverManager.getConnection(this.pathToDatabase);
        System.out.println("Connection established...");
    }

    public void dropTables() throws SQLException {
        String dropTables = reader.getStringFromFile("sqls/dropTables.sql");
        Statement statement = connection.createStatement();
        statement.executeUpdate(dropTables);

    }

    public void resetDatabase() throws SQLException {
        String[] createTables= reader.getStringFromFile("sqls/createTables.sql").split(";");
        String[] insertData = reader.getStringFromFile("sqls/insertData.sql").split(";");
        String[][] queries = {createTables, insertData};
        String[] infos = {"Creating Tables...", "Inserting data..."};
        Statement statement = connection.createStatement();
        System.out.println("Resetting database...");
        System.out.println("Dropping tables...");
        dropTables();
        for (int i = 0; i<queries.length; i++) {
            System.out.println(infos[i]);
            for (String query: queries[i])
                if (!query.trim().equals("")) {
                    statement.executeUpdate(query);
                }
        }
        System.out.println("DONE!");
    }

    public void migrateDb() throws SQLException {
        String[] createTables= reader.getStringFromFile("sqls/createTables.sql").split(";");
        Statement statement = connection.createStatement();
        System.out.println("Creating Tables...");
        for (String query: createTables)
            if (!query.trim().equals("")) {
                statement.executeUpdate(query);
            }
        System.out.println("Done!");
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
        System.out.println("Connection terminated...");
    }

}
