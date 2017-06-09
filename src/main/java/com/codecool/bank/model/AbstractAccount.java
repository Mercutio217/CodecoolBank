package com.codecool.bank.model;

import java.util.Date;

public abstract class AbstractAccount {
    private Integer id;
    private Integer customerId;
    private String number;
    private AccountStatus accountStatus;
    private Date openDate;
    private Long balance;
    private Long debitLine;
    private Integer interest;

    public AbstractAccount(Integer id, Integer customerId, String number, AccountStatus accountStatus, Date openDate,
                            long balance, long debitLine, int Interest){
        this.id = id;
        this.customerId = customerId;
        this.number = number;
        this.accountStatus = accountStatus;
        this.openDate = openDate;
    }

    public Integer getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public Long getBalance() {
        return balance;
    }

    public Long getDebitLine() {
        return debitLine;
    }

    public Integer getInterest() {
        return interest;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public void setDebitLine(Long debitLine) {
        this.debitLine = debitLine;
    }

    public void setInterest(Integer interest) {
        this.interest = interest;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
