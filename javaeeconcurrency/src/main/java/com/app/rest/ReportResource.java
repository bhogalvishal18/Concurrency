/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.rest;

import com.app.beans.BankAccount;
import com.app.dao.BankAccountDao;
import com.app.runnable.ReportProcessor;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author Vishal
 */
@Path("report")
public class ReportResource {

    private BankAccountDao dao;
//    public ReportResource() {
//        try {
//            //JNDI lookup
//            InitialContext context=new InitialContext();
//            ManagedExecutorService executorService=(ManagedExecutorService) context.lookup("java:comp/DefaultManagedExecutorService");
//        } catch (NamingException ex) {
//            Logger.getLogger(ReportResource.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    @Resource(lookup = "java:comp/DefaultManagedExecutorService")
    private ManagedExecutorService service;

    public ReportResource() {
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/bank?autoReconnect=true&useSSL=false");
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setUser("root");
            dataSource.setPassword("root");

            dao = new BankAccountDao(dataSource);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(ReportResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    public String generateReport() throws Exception {
        List<BankAccount> account = dao.getAllbankAccount();
        for (BankAccount accounts : account) {
            try {
                Future<Boolean> future = service.submit(new ReportProcessor(accounts, dao));
                System.out.println("report generated ?" + future.get());
            } catch (InterruptedException ex) {
                Logger.getLogger(ReportResource.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(ReportResource.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "Report Generation Task Submitted";
    }

}
