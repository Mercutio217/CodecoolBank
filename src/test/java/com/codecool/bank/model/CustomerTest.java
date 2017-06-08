package com.codecool.bank.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

/**
 * Created by mercutio on 09.06.17.
 */
class CustomerTest {

    Customer testCustomer;

    @BeforeEach
    void setUp() {
        testCustomer = new Customer(1, "Janusz", "Janicki", new Date(), true, new Date());
    }
    @Test
    void getAccountsDefaultListSize() {
        assertEquals(0, testCustomer.getAccounts().size());
    }

    @Test
    void setAccounts() {
        CreditAccount mockAccount0 = mock(CreditAccount.class);
        SavingAccount mockAccount1 = mock(SavingAccount.class);
        CreditAccount mockAccount2 = mock(CreditAccount.class);
        SavingAccount mockAccount3 = mock(SavingAccount.class);
        List<AbstractAccount> mockList = new ArrayList<>(Arrays.asList(mockAccount0, mockAccount1, mockAccount2, mockAccount3));
        testCustomer.setAccounts(mockList);
        assertEquals(4, testCustomer.getAccounts().size());
        assertEquals(CreditAccount.class, testCustomer.getAccounts().get(2).getClass());
    }

    @Test
    void getId() {
    }

    @Test
    void getFirstName() {
    }

    @Test
    void getLastName() {
    }

    @Test
    void getCreateDate() {
    }

    @Test
    void getActive() {
    }

    @Test
    void getLastLogin() {
    }

    @Test
    void getLogin() {
    }

    @Test
    void getPassword() {
    }

    @Test
    void setLastLogin() {
    }

}