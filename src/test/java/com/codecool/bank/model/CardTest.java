package com.codecool.bank.model;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mock.*;
import static org.mockito.Mockito.mock;

/**
 * Created by mercutio on 08.06.17.
 */
class CardTest {

    Card testCard;

    @Test
    void getNumber() {
        CardType mockType = mock(CardType.class);
        CardStatus mockStatus = mock(CardStatus.class);
        Long testval = 35235L;
        testCard = new Card(1, "12q41324r3", mockType, new Date(), testval, testval, testval, 1, mockStatus);
        assertEquals("12q41324r3", testCard.getNumber());
    }

}