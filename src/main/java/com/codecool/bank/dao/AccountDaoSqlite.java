package com.codecool.bank.dao;

import com.codecool.bank.App;
import com.codecool.bank.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountDaoSqlite {
    DateFormat df;

    public AccountDaoSqlite(){
        df = new SimpleDateFormat("dd-MM-yyyy");
    }

    public List<AbstractAccount> getAccountsByCustomerId(Integer customerId) throws SQLException, ParseException, InvalidAccountTypeException {
        Connection con = App.getApp().getConnection();
        PreparedStatement stat = con.prepareStatement(
                "SELECT * FROM `Accounts` WHERE CustomerId = ?");
        stat.setInt(1, customerId);
        ResultSet rs = stat.executeQuery();

        List<AbstractAccount> accountList = new ArrayList<>();
        while (rs.next()) {
            accountList.add(createAccount(rs));
        }
        return accountList;
    }

    private AbstractAccount createAccount(ResultSet rs) throws SQLException, ParseException, InvalidAccountTypeException {
        Integer acId = rs.getInt("AccountId");
        Integer customerId = rs.getInt("CustomerId");
        String acNumber = rs.getString("Number");
        AccountType acType= getAccountType(rs.getInt("AccountTypeId"));
        AccountStatus acStatus = getAccountStatus(rs.getInt("AccountStatusId"));
        Date openDate = df.parse(rs.getString ("OpenDate"));
        Long balance = rs.getLong("Balance");
        Long debitLine = rs.getLong("DebitLine");
        Integer intrest = rs.getInt("Interest");
        if (acType.getName().equals("saving account")){
            return new SavingAccount(acId, customerId, acNumber, acStatus, openDate, balance, debitLine, intrest, acType);
        } else if (acType.getName().equals("credit account")) {
            return new CreditAccount(acId, customerId, acNumber, acStatus, openDate, balance, debitLine, intrest, acType);
        }
        throw new InvalidAccountTypeException("Error! Account type Doesn't exist");
    }

    public AccountType getAccountType(Integer accountTypeId) throws SQLException {
        Connection con = App.getApp().getConnection();
        PreparedStatement stat = con.prepareStatement(
                "SELECT * FROM `AccountTypes` WHERE AccountTypeId = ?");
        stat.setInt(1, accountTypeId);
        ResultSet rs = stat.executeQuery();
        return new AccountType(
                rs.getInt("AccountTypeId"),
                rs.getString("Name"),
                rs.getString("Description")
        );
    }

    public AccountStatus getAccountStatus(Integer accountTypeId) throws SQLException {
        Connection con = App.getApp().getConnection();
        PreparedStatement stat = con.prepareStatement(
                "SELECT * FROM `AccountStatuses` WHERE AccountStatusId = ?");
        stat.setInt(1, accountTypeId);
        ResultSet rs = stat.executeQuery();
        return new AccountStatus(
                rs.getInt("AccountStatusId"),
                rs.getString("Name"),
                rs.getString("Description")
        );
    }
}
