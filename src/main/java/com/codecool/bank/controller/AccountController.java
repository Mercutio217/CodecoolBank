package com.codecool.bank.controller;

import com.codecool.bank.dao.AccountDaoSqlite;

import java.sql.Connection;

/**
 * Created by mercutio on 09.06.17.
 */
public class AccountController {
    AccountDaoSqlite dao;

    public AccountController() {
        dao = new AccountDaoSqlite();
    }

    public void addAccount(Integer customerId) {

    }
}
