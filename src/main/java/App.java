import dao.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class App {
    private static App INSTANCE;
    private DatabaseConnection dbcon;

    private App() {
    }

    public static App getApp(){
        return INSTANCE;
    }

    public void setConnection(String pathToDatabase) throws SQLException {
        dbcon = new DatabaseConnection(pathToDatabase);
        dbcon.openConnection();
    }

    public Connection getConnection() throws SQLException {
        return dbcon.getConnection();
    }

//    public void resetDb() throws SQLException {
//        dbcon.resetDatabase();
//    }

    public void migrateDb() throws SQLException {
        dbcon.migrateDb();
    }

    public void closeConnection() throws SQLException {
        dbcon.closeConnection();
    }

    public static void run() throws SQLException {
        if (INSTANCE == null){
            INSTANCE = new App();
        }
    }
}
