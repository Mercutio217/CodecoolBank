package com.codecool.bank.model;

import java.util.Date;

public class Transaction {
    private Integer id;
    private Date dateOfTransaction;
    private TransactionType transactionType;
    private Long value;
    private String description;
    private TransactionStatus transactionStatus;
    private AbstractAccount sourceAccount;
    private Card sourceCard;

    public Transaction(Integer id, Date dateOfTransaction, TransactionType transactionType, Long value,
                       String description, TransactionStatus transactionStatus, AbstractAccount sourceAccount,
                       Card sourceCard) {
        this.id = id;
        this.dateOfTransaction = dateOfTransaction;
        this.transactionType = transactionType;
        this.value = value;
        this.description = description;
        this.transactionStatus = transactionStatus;
        this.sourceAccount = sourceAccount;
        this.sourceCard = sourceCard;
    }
}
