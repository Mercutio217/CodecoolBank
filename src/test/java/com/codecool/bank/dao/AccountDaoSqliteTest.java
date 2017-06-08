package com.codecool.bank.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by mercutio on 08.06.17.
 */
class AccountDaoSqliteTest {

    AccountDaoSqlite testDao;

    @BeforeEach
    void setUp() {
//        testDao = new AccountDaoSqlite();
    }

    @Test
    void testGetAccountsByCustomerId() throws ParseException, InvalidAccountTypeException, SQLException {
//        assertEquals(testDao.getAccountsByCustomerId(1).get(1).getInterest(), (Integer) 07);
    }

}