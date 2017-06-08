package com.codecool.bank.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

/**
 * Created by mercutio on 08.06.17.
 */
class CreditAccountTest {

    CreditAccount creditAccount;

    @Test
    void testConstructor() {
        AccountType mockType = mock(AccountType.class);
        AccountStatus mockStatus = mock(AccountStatus.class);
        creditAccount = new CreditAccount(1, 1 ,"dawfa324234324", mockStatus, new Date(),
                123142L, 35235L, 13, mockType);
        assertEquals("dawfa324234324", creditAccount.getNumber());
    }

}