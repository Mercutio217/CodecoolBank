package com.codecool.bank.dao;

import com.codecool.bank.App;
import com.codecool.bank.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDaoSqlite {

//    public Customer login(String login, String password) throws SQLException {
//        Connection con = App.getApp().getConnection();
//        PreparedStatement stat = con.prepareStatement(
//        "SELECT * FROM `Customers` WHERE login = ? AND password = ?");
//        stat.setString(1,login);
//        stat.setString(2, password);
//        ResultSet result = stat.executeQuery();
//        if(result.getFetchSize() != 1){
//
//        }
//
//    }
}
