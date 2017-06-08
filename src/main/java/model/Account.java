package model;

/**
 * Created by mercutio on 08.06.17.
 */
public interface Account {

    void deposit(long amount);
    void withdraw(long amount);
    long getBalance();
    int getId();
}
