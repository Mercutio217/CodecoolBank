package com.codecool.bank.model;

import java.util.Date;

public class CreditAccount extends AbstractAccount{
    private AccountType type;
    public CreditAccount(Integer id, Integer customerId, String number, AccountStatus accountStatus,
                         Date openDate, long balance, long debitLine, int Interest, AccountType type) {

        super(id, customerId, number, accountStatus, openDate, balance, debitLine, Interest);
        this.type = type;
    }
}
