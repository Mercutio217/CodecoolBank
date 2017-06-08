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
    private AbstractAccount destinationAccount;

    public Transaction(Integer id, Date dateOfTransaction, TransactionType transactionType, Long value,
                       String description, TransactionStatus transactionStatus, AbstractAccount sourceAccount, AbstractAccount destinationAccount) {
        this.id = id;
        constructorHelper(dateOfTransaction, transactionType, value, description, transactionStatus, sourceAccount, destinationAccount);
    }

    public Transaction(Date dateOfTransaction, TransactionType transactionType, Long value,
                       String description, TransactionStatus transactionStatus, AbstractAccount sourceAccount, AbstractAccount destinationAccount) {

        constructorHelper(dateOfTransaction, transactionType, value, description, transactionStatus, sourceAccount, destinationAccount);
    }


    private void constructorHelper(Date dateOfTransaction, TransactionType transactionType, Long value,
                                   String description, TransactionStatus transactionStatus, AbstractAccount sourceAccount, AbstractAccount destinationAccount){
        this.dateOfTransaction = dateOfTransaction;
        this.transactionType = transactionType;
        this.value = value;
        this.description = description;
        this.transactionStatus = transactionStatus;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
    }

    public Date getDateOfTransaction() {
        return dateOfTransaction;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public Long getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public AbstractAccount getSourceAccount() {
        return sourceAccount;
    }

    public AbstractAccount getDestinationAccount() {
        return destinationAccount;
    }
}
