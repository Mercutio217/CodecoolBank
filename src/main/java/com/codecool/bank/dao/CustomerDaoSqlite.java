package com.codecool.bank.dao;

import com.codecool.bank.App;
import com.codecool.bank.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerDaoSqlite {
    DateFormat df;
    Connection con;

    public CustomerDaoSqlite() throws SQLException {
        df = new SimpleDateFormat("dd-MM-yyyy");
        con = App.getApp().getConnection();
    }

    public Customer login(String login, String password) throws SQLException, InvalidCredentialsException, ParseException, InvalidAccountTypeException {
        PreparedStatement stat = con.prepareStatement(
        "SELECT * FROM `Customers` WHERE login = ? AND password = ?");
        stat.setString(1,login);
        stat.setString(2, password);
        ResultSet rs = stat.executeQuery();
        if(rs.isClosed()){
            throw new InvalidCredentialsException("Incorrect credentials");
        }
        Customer cus = customerFromResultSet(rs);
        cus.setLastLogin(new Date());
        addOrUpdate(cus);
        return cus;

    }

    private Customer customerFromResultSet(ResultSet rs) throws SQLException, ParseException, InvalidAccountTypeException {

        Integer id = rs.getInt("id");

        String fName = rs.getString("FirstName");
        String lName = rs.getString("LastName");

        Date createDate = df.parse(rs.getString("CreateDate"));
        Boolean isActive = rs.getInt("isActive") == 1;
        String lastLogin = rs.getString("lastLogin");
        Date dateLogin = lastLogin == null ? null : df.parse(lastLogin);
        Customer cust = new Customer(id, fName, lName, createDate, isActive, dateLogin);
        cust.setAccounts(new AccountDaoSqlite().getAccountsByCustomerId(id));
        return cust;
    }

    public void addOrUpdate(Customer customer) throws SQLException {
        String insertQuery = "INSERT INTO customers (FirstName, LastName, Login, Password, CreateDate, IsActive, LastLogin) VALUES (?, ?, ?, ?, ?, ?, ?);";
        String updateQuery = "UPDATE customers SET IsActive = ?, LastLogin = ? WHERE id = ?;";

        Integer customerId = customer.getId();
        String lastLogin = customer.getLastLogin() == null ? null : df.format(customer.getLastLogin());
        System.out.println(new Date());
        System.out.println(lastLogin);
        PreparedStatement preparedStatement;

        if (customerId == null) {
            preparedStatement = con.prepareStatement(insertQuery);
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getLogin());
            preparedStatement.setString(4, customer.getPassword());
            preparedStatement.setString(5, df.format(customer.getCreateDate()));
            preparedStatement.setInt(6, customer.getActive() ? 1 : 0);
            preparedStatement.setString(7, lastLogin);
        } else {
            preparedStatement = con.prepareStatement(updateQuery);
            preparedStatement.setInt(1, customer.getActive() ? 1 : 0);
            preparedStatement.setString(2, lastLogin);
            preparedStatement.setInt(3, customerId);
        }

        preparedStatement.executeUpdate();
    }

    public void findById(Integer id) throws SQLException, CustomerNotFoundException, ParseException, InvalidAccountTypeException {
        PreparedStatement stat = con.prepareStatement(
                "SELECT * FROM `Customers` WHERE id = ?");
        stat.setInt(1,id);
        ResultSet rs = stat.executeQuery();

        if(rs.isClosed()){
            throw new CustomerNotFoundException("Customer not found");
        }

        customerFromResultSet(rs);
    }
}
