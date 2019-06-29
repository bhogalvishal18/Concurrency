/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.runnable;

import java.io.File;
import java.util.Locale;

/**
 *
 * @author Vishal
 */
public class CleaningScheduler implements Runnable{

    @Override
    public void run() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     File folder=new File("D:/tricks");
     File[] files=folder.listFiles();
     for(File file:files)
     {
        if(System.currentTimeMillis()-file.lastModified()>5*60*1000)
             System.out.println("This file deleted"+file.getName());
     }
    }
    
}
