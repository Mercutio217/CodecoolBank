package com.codecool.bank.dao;

import com.codecool.bank.App;
import com.codecool.bank.model.Customer;
import org.junit.jupiter.api.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by mercutio on 08.06.17.
 */
class CustomerDaoSqliteTest {

    CustomerDaoSqlite testDao;

    @BeforeAll
    static void setAll() throws SQLException {
        App.run();
        App.getApp().setConnection("jdbc:sqlite:src/main/resources/database/codecool-bank.db");
    }

    @BeforeEach
    void setUp() throws SQLException {
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

    @Nested
    class InstatiatedTest {

        @BeforeEach
        void nestedSetUp() throws SQLException {
            App.run();
            App.getApp().setConnection("jdbc:sqlite:src/main/resources/database/codecool-bank.db");
            App.getApp().resetDb();
        }

        @AfterEach
        void tearDown() throws SQLException {
            App.getApp().getConnection().close();
        }

        @Test
        void testAdd() throws SQLException {
            testDao.addOrUpdate(new Customer("Ozjasz", "Goldberg", "korwin", "mikke"));
            PreparedStatement preparedStatement =
                    App.getApp().getConnection().prepareStatement("SELECT * FROM `Customers` WHERE id = (SELECT MAX(id) FROM 'Customers');");
            ResultSet set = preparedStatement.executeQuery();
            assertEquals("Ozjasz", set.getString("FirstName"));
        }

        @Test
        @Disabled
        void testUpdate() throws SQLException {
            Date newDate = new Date();
            Customer customer = new Customer(1, "Janusz", "Marcinkowski", new Date(), true, newDate);
            testDao.addOrUpdate(customer);
            PreparedStatement preparedStatement =
                    App.getApp().getConnection().prepareStatement("SELECT * FROM `Customers` WHERE id = 1;");
            ResultSet set = preparedStatement.executeQuery();
            String today = new SimpleDateFormat("DD-MM-YYYY").format(new Date());
            assertEquals(today, set.getString("LastLogin"));
        }

        @Test
        void testFindByIdThrowsException() throws SQLException, ParseException, InvalidAccountTypeException, CustomerNotFoundException {
            assertThrows(Exception.class, () -> testDao.findById(1));

        }
    }
}