package com.codecool.bank.dao;

import com.codecool.bank.App;
import com.codecool.bank.model.AccountStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by mercutio on 08.06.17.
 */
class AccountDaoSqliteTest {

    AccountDaoSqlite testDao;

    @BeforeAll
    static void setDb() throws SQLException {
        App.run();
        App.getApp().setConnection("jdbc:sqlite:src/main/resources/database/codecool-bank.db");

    }

    @BeforeEach
    void setUp() throws SQLException {

//        App.getApp().resetDb();
        testDao = new AccountDaoSqlite();
    }

    @Test
    void testConstructor() {
        assertEquals(SimpleDateFormat.class, testDao.df);
    }
    @Test
    void testGetAccountsByCustomerId() throws ParseException, InvalidAccountTypeException, SQLException {
        assertEquals((Integer) testDao.getAccountsByCustomerId(1).size(), (Integer) 2);
    }

    @Test
    void testGetAccountType() throws SQLException {
        assertEquals("saving account", testDao.getAccountType(1).getName());
    }

    @Test
    void testGetNonExistentType() throws SQLException {
        assertThrows(Exception.class, () -> testDao.getAccountType(87293));
    }

    @Test
    void testGetAccountStatus() throws SQLException {
        assertEquals(AccountStatus.class, testDao.getAccountStatus(1).getClass());
    }

    @Test
    void testGetNonExistentStatus() throws SQLException {
        assertThrows(Exception.class, () -> testDao.getAccountType(3));
    }

}