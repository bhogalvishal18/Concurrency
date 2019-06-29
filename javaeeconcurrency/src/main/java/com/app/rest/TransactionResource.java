/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.rest;

import com.app.runnable.TransactionProcessor;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author Vishal
 */
@Path("transaction")
public class TransactionResource {
    
    @Resource(lookup = "java:comp/DefaultManagedExecutorService")
    private ManagedExecutorService service;
   @GET
   public String executeTransaction()
   {
       service.submit(new TransactionProcessor());
       return "Transaction Submitted Please Check console";
   }
}
