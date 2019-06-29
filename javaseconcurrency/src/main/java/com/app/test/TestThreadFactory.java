/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.test;

import com.app.custom.CustomThreadFactory;
import com.app.runnable.LoggingProcessor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vishal
 */
public class TestThreadFactory {
    public static void main(String[] args) {
        ExecutorService service= Executors.newFixedThreadPool(3, new CustomThreadFactory());
        Logger.getLogger(LoggingProcessor.class.getName()).log(Level.INFO,"Logging something");
        for(int i=0;i<6;i++)
        {
            service.submit(new LoggingProcessor());
        }
    }
 
}
