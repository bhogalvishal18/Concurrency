/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.test;

import com.app.runnable.LoggingProcessor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vishal
 */
public class TestOtherAPI {

    public static void main(String[] args) {

        try {
            
            ExecutorService service = Executors.newFixedThreadPool(2);
            List<Callable<Boolean>> callable = new ArrayList<>();
            try {
                callable.add(new LoggingProcessor());
                callable.add(new LoggingProcessor());
                callable.add(new LoggingProcessor());
                callable.add(new LoggingProcessor()); 
                callable.add(new LoggingProcessor());
                callable.add(new LoggingProcessor());
                callable.add(new LoggingProcessor());
                List<Future<Boolean>> futures = service.invokeAll(callable);
                for (Future<Boolean> future : futures) {
                    try {
                        System.out.println("operation result " + future.get());
                    } catch (ExecutionException ex) {
                        Logger.getLogger(TestOtherAPI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(TestOtherAPI.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("operating for invoke any "+service.invokeAny(callable));
            service.shutdown();
            System.out.println(service.awaitTermination(30, TimeUnit.SECONDS));
        } catch (InterruptedException ex) {
            Logger.getLogger(TestOtherAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(TestOtherAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
