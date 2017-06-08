package com.codecool.bank.controller;

import com.codecool.bank.dao.CustomerDaoSqlite;
import com.codecool.bank.dao.CustomerNotFoundException;
import com.codecool.bank.dao.InvalidAccountTypeException;
import com.codecool.bank.model.Customer;

import java.sql.SQLException;
import java.text.ParseException;

public class CustomerController {
    CustomerDaoSqlite dao;

    public CustomerController() throws SQLException {
        dao = new CustomerDaoSqlite();
    }

    public void addCustomer(String firstName, String lastName, String login, String password) throws SQLException {
        Customer cust = new Customer(firstName, lastName, login, password);
        dao.addOrUpdate(cust);
    }

    public void deactivateCustomer(Integer customerId) throws SQLException, ParseException, InvalidAccountTypeException, CustomerNotFoundException {
        dao.findById(1);
    }
}
