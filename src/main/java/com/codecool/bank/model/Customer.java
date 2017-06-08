package com.codecool.bank.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;


public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private Date createDate;
    private Boolean isActive;
    private Date lastLogin;
    private List<AbstractAccount> accounts;

    public Customer(Integer id, String firstName, String lastName, Date createDate, Boolean isActive, Date lastLogin){
        constructorHelper(firstName, lastName, createDate, isActive, lastLogin);
        this.id = id;

    }

    public Customer(String firstName, String lastName, String login, String password){
        this.login = login;
        this.password = password;
        Date createDate = new Date();
        constructorHelper(firstName, lastName, createDate, true, null);
    }

    private void constructorHelper(String firstName, String lastName, Date createDate, Boolean isActive, Date lastLogin){
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.createDate = createDate;
        this.lastLogin = lastLogin;
    }

    public List<AbstractAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AbstractAccount> accounts) {
        this.accounts = accounts;
    }

    public AbstractAccount getAccount(Integer accountId){
        return accounts.stream().filter(account -> Objects.equals(account.getId(), accountId)).findFirst().orElse(null);
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Boolean getActive() {
        return isActive;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
}
