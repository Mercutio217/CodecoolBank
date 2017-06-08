package com.codecool.bank.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

/**
 * Created by mercutio on 08.06.17.
 */
class TransactionTest {
    Transaction transaction;
    @Test
    void testConstructor() {
        TransactionType transactionType = mock(TransactionType.class);
        TransactionStatus transactionStatus = mock(TransactionStatus.class);
        CreditAccount creditAccount = mock(CreditAccount.class);
        Card mockCard = mock(Card.class);
        transaction = new Transaction(2, new Date(),
                transactionType, 23124L, "DUPA", transactionStatus, creditAccount, mockCard);
// This test is a joke
        assertEquals(Transaction.class, transaction.getClass());
    }

}