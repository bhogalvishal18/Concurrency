/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.test;

import com.app.runnable.CleaningScheduler;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Vishal
 */
public class TestScheduler {
    public static void main(String[] args) {
        ScheduledExecutorService service=Executors.newSingleThreadScheduledExecutor();
        //service.schedule(new  CleaningScheduler(), 2, TimeUnit.SECONDS);
        //service.scheduleAtFixedRate(new CleaningScheduler(), 5, 4, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(new CleaningScheduler(), 5, 4, TimeUnit.SECONDS);
    //first task after an initial delay of 5s
    //2s for the task to execute 
    // waiting time of 4s
    }
 
}
