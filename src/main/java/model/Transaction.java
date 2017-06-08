package model;

import java.math.BigInteger;
import java.util.Date;

/**
 * Created by mercutio on 07.06.17.
 */
public class Transaction {
    private Date dateOfTransaction;
    private Integer transactionId;
    private Integer transactionTypeId;
    private BigInteger value;
    private AbstractAccount account;

}
