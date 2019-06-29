/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.runnable;

import java.security.AccessController;
import javax.security.auth.Subject;

/**
 *
 * @author Vishal
 */
public class ContextServiceRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        //Capture Security of App 
        Subject subject=Subject.getSubject(AccessController.getContext());
        System.out.println("Security info from normal thread"+subject);
    }
    
}
