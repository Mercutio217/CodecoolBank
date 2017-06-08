package com.codecool.bank.model;

import java.util.Date;
import java.util.List;


public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;
    private Boolean isActive;
    private String number;
    private Date lastLogin;
    private List<Account> accounts;

    public Customer(Integer id, String firstName, String lastName, Boolean isActive, String number, Date lastLogin){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.isActive = isActive;
        this.lastLogin = lastLogin;
    }

    public void addAccount(Account account){
        accounts.add(account);
    }

    public void deleteAccount(Account account){

    }

    public Account getAccount(Integer accountId){
        return accounts.stream().filter(account -> account.getAccountId() == accountId).findFirst().orElse(null);
    }

}
