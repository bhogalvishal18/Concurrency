/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.runnable;

/**
 *
 * @author Vishal
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.*;

public class AppThread extends Thread {
    @Override
    public void run()
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
            
        }
    }
}
