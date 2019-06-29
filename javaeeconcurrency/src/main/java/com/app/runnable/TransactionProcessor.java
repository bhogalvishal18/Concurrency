/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.runnable;

import com.app.ejbbeans.TransactionBean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import javax.transaction.UserTransaction;

/**
 *
 * @author Vishal
 */
public class TransactionProcessor implements Runnable{

    private UserTransaction userTransaction;
    private TransactionBean bean;
    public TransactionProcessor()
    {
        try {
            InitialContext context=new InitialContext();
            userTransaction=(UserTransaction)context.lookup("java:comp/UserTransaction");
            bean=(TransactionBean)context.lookup("java:module/tx-bean");
        } catch (NamingException ex) {
            Logger.getLogger(TransactionProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void run() {
        try {
            userTransaction.begin();
            bean.saveBankAccountTransaction();
            bean.saveBankAccountTransactionLog();
            userTransaction.commit();
        } catch (Exception ex) {
         
            try {
                System.out.println("Rolling Back!!!"+ex.getMessage());
                userTransaction.rollback();
            } catch (IllegalStateException ex1) {
                Logger.getLogger(TransactionProcessor.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (SecurityException ex1) {
                Logger.getLogger(TransactionProcessor.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (SystemException ex1) {
                Logger.getLogger(TransactionProcessor.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    
    }
    
}
