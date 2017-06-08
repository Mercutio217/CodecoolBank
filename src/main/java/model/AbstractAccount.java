package model;

import java.util.Date;

/**
 * Created by mercutio on 08.06.17.
 */
public class AbstractAccount {

    private int id;
    private int customerId;
    private long balance;
    private String number;
    private AccountStatus accountStatus;
    private Date openDate;
    private long debitLine;
    private Integer interest;

    public AbstractAccount(int id, int customerId, long balance, String number,
                           AccountStatus accountStatus, Date openDate,
                           long debitLine, Integer interest) {
        this.id = id;
        this.customerId = customerId;
        this.balance = balance;
        this.number = number;
        this.accountStatus = accountStatus;
        this.openDate = openDate;
        this.debitLine = debitLine;
        this.interest = interest;
    }
}
