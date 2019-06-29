/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.test;

import com.app.runnable.AppThread;

/**
 *
 * @author Vishal
 */
public class TestThread {
    public static void main(String[] args) {
        //state of thread
        AppThread thread1=new AppThread();//new
        AppThread thread2=new AppThread();
        AppThread thread3=new AppThread();
        thread1.start();//runnable ready to run
        thread2.start();
        thread3.start();
        //excute run//running
        //job completed //terminate
        
    }
}
