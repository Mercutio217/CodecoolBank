package com.codecool.bank.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by mercutio on 08.06.17.
 */
class CardStatusTest {

    CardStatus cardStatus;

    @Test
    void testConstructor() {
        cardStatus = new CardStatus(1, "Active", "no active");
        assertAll(
                () -> assertEquals((Integer)1, cardStatus.getId()),
                () -> assertEquals("Active", cardStatus.getName()),
                () -> assertEquals("no active", cardStatus.getDescription())
        );
    }
}