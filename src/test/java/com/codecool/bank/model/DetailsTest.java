package com.codecool.bank.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by mercutio on 08.06.17.
 */
class DetailsTest {

    Details testObject;

    @Test
    void testIfConstructorSetsProperName() {
        testObject = new AccountStatus(1, "suspended", "coz ya broke, man!");
        assertEquals("suspended", testObject.getName());
    }

    @Test
    void testIfConstructorSetsProperId() {
        testObject = new AccountType(75, "moniezAccount", "and stuff");
        assertEquals((Integer) 75, testObject.getId());
    }

    @Test
    void testIfConstructorSetsProperDescription() {
        testObject = new TransactionStatus(1, "namew", "description");
        assertEquals("description", testObject.getDescription());
    }

    @Test
    void addtionalTestForTransactionType() {
        testObject = new TransactionType(1, "string", "and string");
        assertEquals("string", testObject.getName());
    }

}