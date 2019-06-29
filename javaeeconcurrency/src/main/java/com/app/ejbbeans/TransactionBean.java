/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ejbbeans;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author Vishal
 */
@Stateless(name = "tx-bean")
public class TransactionBean {

    @Resource(lookup = "jdbc/source1")
    private DataSource source1;
    @Resource(lookup = "jdbc/source2")
    private DataSource source2;

    public void saveBankAccountTransaction() throws SQLException{
        Connection connection=source1.getConnection();
        Statement statement=connection.createStatement();
        statement.executeUpdate("insert into bank_account_transaction values(7,1102,'debit',480,'"+new Date(System.currentTimeMillis())+"')");
    }
    public void saveBankAccountTransactionLog()throws SQLException {
         Connection connection=source2.getConnection();
        Statement statement=connection.createStatement();
        statement.executeUpdate("insert into bank_account_transaction values(1,7,'system','"+new Date(System.currentTimeMillis())+"')");
       
    }
}
