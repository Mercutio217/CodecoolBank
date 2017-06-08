package com.codecool.bank.model;

import java.util.Date;

public class SavingAccount extends AbstractAccount{
    private AccountType type;
    public SavingAccount(Integer id, Integer customerId, String number, AccountStatus accountStatus,
                         Date openDate, long balance, long debitLine, int Interest, AccountType type) {

        super(id, customerId, number, accountStatus, openDate, balance, debitLine, Interest);
        this.type = type;
    }
}
