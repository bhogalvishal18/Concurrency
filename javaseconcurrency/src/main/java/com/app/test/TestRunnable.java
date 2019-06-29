/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 *
 * @author Vishal
 */
public class TestRunnable {
    public static void main(String[] args) {
        Runnable runnable=()->
        {
            try(BufferedReader reader=new BufferedReader(new FileReader(new File("C:\\Users\\Vishal\\Documents\\NetBeansProjects\\sample.txt"))))
        {
            String line=null;
            while((line=reader.readLine())!=null)
            {
                System.out.println(Thread.currentThread().getName()+"Reading...."+line);
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());   
        }
        };
       // Thread thread=new Thread(runnable);
       // thread.start();
        Executor executor=Executors.newSingleThreadExecutor();
        executor.execute(runnable);
    }
}
