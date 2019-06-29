/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.rest;

import com.app.runnable.LoggingProcessor;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedThreadFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author Vishal
 */
@Path("logData")
public class LoggingResource {

    @Resource(lookup = "java:comp/DefaultManagedThreadFactory")
    private ManagedThreadFactory threadfactory;
    @GET
    public String logData()
    {
        Thread thread=threadfactory.newThread(new LoggingProcessor());
        thread.setName("Logging thread");
        thread.start();
        ExecutorService service=getApplicationPool();
        for(int i=0;i<7;i++)
        {
            service.submit(new LoggingProcessor());
        }
        service.shutdown();
        return "Logging thread check console";
    }
    public ExecutorService getApplicationPool()
    {
        ExecutorService service=new ThreadPoolExecutor(3, 10, 5, TimeUnit.SECONDS, new ArrayBlockingQueue(2), threadfactory);
   return  service;
    }
            
}
