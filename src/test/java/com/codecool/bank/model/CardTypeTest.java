package com.codecool.bank.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by mercutio on 08.06.17.
 */
class CardTypeTest {
    CardType cardType;

    @Test
    void testConstructor() {
        cardType = new CardType(1, "Active", "no active");
        assertAll(
                () -> assertEquals((Integer)1, cardType.getId()),
                () -> assertEquals("Active", cardType.getName()),
                () -> assertEquals("no active", cardType.getDescription())
        );
    }
}