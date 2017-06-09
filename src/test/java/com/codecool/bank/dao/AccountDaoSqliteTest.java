package com.codecool.bank.dao;

import com.codecool.bank.App;
import com.codecool.bank.model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        testDao = new AccountDaoSqlite();
    }

    @Test
    void testConstructor() {
        assertEquals(SimpleDateFormat.class, testDao.df.getClass());
    }

    @Test
    void testGetAccountsByCustomerId() throws ParseException, InvalidAccountTypeException, SQLException {
        assertEquals((Integer) testDao.getAccountsByCustomerId(2).size(), (Integer) 1);
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


    @Nested
    class AddAndRemoveTests {

        CreditAccount prepareTestAccount() {
            Customer testMeDaddy = mock(Customer.class);
            when(testMeDaddy.getId()).thenReturn(1);
            AccountType mockType = mock(AccountType.class);
            when(mockType.getId()).thenReturn(2);
            AccountStatus mockStatus = mock(AccountStatus.class);
            when(mockStatus.getId()).thenReturn(1);
            CreditAccount creditAccount = new CreditAccount(1, testMeDaddy.getId(), "666", mockStatus, new Date(),
                    123142L, 35235L, 13, mockType);
            creditAccount.setBalance(46823745L);
            creditAccount.setDebitLine(24676842843L);
            creditAccount.setInterest(10);
            return creditAccount;

        }

        @BeforeEach
        void resetDb() throws SQLException {
            App.getApp().resetDb();
        }

        @Test
        void testAddNewAccount() throws SQLException {
            CreditAccount creditAccount = prepareTestAccount();

            testDao.addAccount(creditAccount);

            PreparedStatement preparedStatement =
                    App.getApp().getConnection().prepareStatement("SELECT Number FROM `Accounts` WHERE AccountId = (SELECT MAX(AccountId) FROM 'Accounts');");
            ResultSet set = preparedStatement.executeQuery();
            assertEquals("666", set.getString(1));

        }

        @Test
        void testIfAddInvalidAccountCanBeDone() {
            CreditAccount creditAccount = prepareTestAccount();
            creditAccount.setCustomerId(null);
            assertThrows(SQLException.class, () -> testDao.addAccount(creditAccount));
        }


    }


}