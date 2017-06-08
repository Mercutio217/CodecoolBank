package com.codecool.bank.model;

import java.util.Date;

public abstract class AbstractAccount {
    private String id;
    private String customerId;
    private String number;
    private AccountStatus accountStatus;
    private Date openDate;
    private Long balance;
    private Long debitLine;
    private Integer interest;

    public AbstractAccount(String id, String customerId, String number, AccountStatus accountStatus, Date openDate,
                            long balance, long debitLine, int Interest){
        this.id = id;
        this.customerId = customerId;
        this.number = number;
        this.accountStatus = accountStatus;
        this.openDate = openDate;
    }


}
