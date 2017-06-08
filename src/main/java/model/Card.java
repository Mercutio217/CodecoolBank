package model;

import java.math.BigInteger;
import java.util.Date;

/**
 * Created by mercutio on 07.06.17.
 */
public class Card {

    private BigInteger cardNumber;
    privagite Date validity;
    private BigInteger buyingLimit;
    private BigInteger cashWithdrawalLimit;
    private BigInteger limit;

    public BigInteger getCardNumber() {
        return cardNumber;
    }

    public Date getValidity() {
        return validity;
    }

    public BigInteger getBuyingLimit() {
        return buyingLimit;
    }

    public BigInteger getCashWithdrawalLimit() {
        return cashWithdrawalLimit;
    }

    public BigInteger getLimit() {
        return limit;
    }
}
