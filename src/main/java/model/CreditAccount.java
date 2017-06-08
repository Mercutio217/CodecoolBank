package model;

import java.util.Date;

/**
 * Created by mercutio on 08.06.17.
 */
public class CreditAccount extends AbstractAccount {

    public CreditAccount(int id, int customerId, long balance, String number,
                         AccountStatus accountStatus, Date openDate, long debitLine, Integer interest) {
        super(id, customerId, balance, number, accountStatus, openDate, debitLine, interest);
    }
}
