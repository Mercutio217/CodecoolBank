package com.codecool.bank;

import com.codecool.bank.dao.CustomerDaoSqlite;
import com.codecool.bank.dao.InvalidAccountTypeException;
import com.codecool.bank.dao.InvalidCredentialsException;

import java.sql.SQLException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) {
        try {
            App.run();
            App.getApp().setConnection("jdbc:sqlite:src/main/database.db");
            for (String s: args) {
                if (s.equals("--init-db")){
                    App.getApp().resetDb();
                } else if(s.equals("--migrate-db")){
                    App.getApp().migrateDb();
                }
            }

            System.out.println(new CustomerDaoSqlite().login("awin", "12345").getAccounts());

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (InvalidAccountTypeException e) {
            e.printStackTrace();
        } catch (InvalidCredentialsException e) {
            e.printStackTrace();
        }

        final Thread mainThread = Thread.currentThread();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Closing db connection...");
            try {
                App.getApp().closeConnection();
                mainThread.join();
            } catch (InterruptedException | SQLException e) {
                e.printStackTrace();
            }
        }));

    }
}
