package com.codecool.bank.model;

/**
 * Created by mercutio on 07.06.17.
 */

import java.util.Date;

public class Card {
    Integer id;
    String number;
    CardType type;
    Date validity;
    Long buyingLimit;
    Long cashWithdrawLimit;
    Long limit;
    Integer accountId;
    CardStatus cardStatus;

    public Card(Integer id, String number, CardType type, Date validity, Long buyingLimit,
                Long cashWithdrawLimit, Long limit, Integer accountId, CardStatus cardStatus) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.validity = validity;
        this.buyingLimit = buyingLimit;
        this.cashWithdrawLimit = cashWithdrawLimit;
        this.limit = limit;
        this.accountId = accountId;
        this.cardStatus = cardStatus;
    }
}
