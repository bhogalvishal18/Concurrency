/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.runnable;

import com.app.beans.BankAccount;
import com.app.beans.BankAccountTransaction;
import com.app.dao.BankAccountDao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.concurrent.Callable;

/**
 *
 * @author Vishal
 */
public class ReportProcessor implements Callable<Boolean> {

    private BankAccount account;
    private BankAccountDao dao;

    public ReportProcessor(BankAccount account, BankAccountDao dao) {
        this.account = account;
        this.dao = dao;
    }

    @Override
    public Boolean call() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean reportGenerated = false;
        List<BankAccountTransaction> transactions = dao.getTransactionForAccount(account);
        File file = new File("C:/Users/Vishal/Documents/NetBeansProjects/javaseconcurrency/reports/" + account.getAccNumber() + "_tx_report.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (BankAccountTransaction transaction : transactions) {

                writer.write("Account Number" + transaction.getAccNumber());
                writer.write("Transaction Type" + transaction.getTxType());
                writer.write("Transaction ID" + transaction.getTxId());
                writer.write("Amount" + transaction.getAmount());
                writer.write("Transaction Date" + transaction.getTxDate());
                writer.newLine();
                writer.flush();
            }
        }
        reportGenerated = true;
        return reportGenerated;
    }

}
