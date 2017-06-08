package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mercutio on 07.06.17.
 */
public class Customer {


    private String firstName;
    private String lastName;
    private String number;
    private List<Account> listOfAccounts;
    private boolean isActive;


    public Customer(String firstName, String lastName, String number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.listOfAccounts = new ArrayList<>();
        this.isActive = true;
    }

    public void addAccount(Account account) {
        listOfAccounts.add(account);
    }



}
