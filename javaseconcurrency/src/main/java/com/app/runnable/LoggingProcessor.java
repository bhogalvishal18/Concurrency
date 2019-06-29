/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.runnable;

import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vishal
 */
public class LoggingProcessor implements Callable<Boolean>{

    @Override
    public Boolean call() throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Thread Name "+Thread.currentThread().getName());
      Logger.getLogger(LoggingProcessor.class.getName()).log(Level.INFO,"Logging something");
    return  true;
    }
    
}
