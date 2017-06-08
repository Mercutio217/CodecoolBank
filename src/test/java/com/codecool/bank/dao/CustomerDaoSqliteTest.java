package com.codecool.bank.dao;

import com.codecool.bank.App;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by mercutio on 08.06.17.
 */
class CustomerDaoSqliteTest {

    CustomerDaoSqlite testDao;

    @BeforeEach
    void setUp() throws SQLException {
        App.run();
        App.getApp().setConnection("jdbc:sqlite:src/main/resources/database/codecool-bank.db");
        testDao = new CustomerDaoSqlite();
    }

    @Test
    void testLogin() throws SQLException, InvalidAccountTypeException, InvalidCredentialsException, ParseException {
        testDao.login("jpien", "loglady");
    }

    @Test
    void testLoginNonExistent() {
        assertThrows(InvalidCredentialsException.class, () -> testDao.login("jpasdawien", "tfoja stara"));
    }

}