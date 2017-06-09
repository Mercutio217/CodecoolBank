package com.codecool.bank.dao;

import com.codecool.bank.App;
import com.codecool.bank.model.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class TransactionDaoSqlite {
    SimpleDateFormat df;
    Connection con;

    public TransactionDaoSqlite() throws SQLException {
        df = new SimpleDateFormat("dd-MM-yyyy");
        con = App.getApp().getConnection();
    }

    public void addTransaction(Transaction transaction) throws SQLException {
        String insertQuery = "INSERT INTO Transactions (DateOfTransaction, " +
                "TransactionTypeId, `Value`, Description, TransactionStatusId, SourceAccountId, DestinationAccountId) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement stat = con.prepareStatement(insertQuery);
        stat.setString(1, df.format(transaction.getDateOfTransaction()));
        stat.setInt(2,transaction.getTransactionType().getId());
        stat.setLong(3, transaction.getValue());
        stat.setString(4, transaction.getDescription());
        stat.setInt(5, transaction.getTransactionStatus().getId());
        stat.setInt(6, transaction.getSourceAccount().getId());
        stat.setInt(7, transaction.getDestinationAccount().getId());
        stat.executeUpdate();
    }
}
