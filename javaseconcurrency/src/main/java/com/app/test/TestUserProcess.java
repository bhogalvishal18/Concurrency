/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.test;

import com.app.dao.UserDao;
import com.app.runnable.UserProcessor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vishal
 */
public class TestUserProcess {
    public static void main(String[] args) {
        ExecutorService service=Executors.newSingleThreadExecutor();
        List<String> users=getUserFromFile("C:\\Users\\Vishal\\Documents\\NetBeansProjects\\new_users.txt");
        UserDao dao=new UserDao();
        for(String user:users)
       {
            try {
                Future<Integer> future=service.submit(new UserProcessor(user,dao));
                System.out.println("Result"+future.get());
            } catch (InterruptedException ex) {
                Logger.getLogger(TestUserProcess.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(TestUserProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
        service.shutdown();
        System.out.println("Main is Over!");
    }
 public static List<String> getUserFromFile(String filename)
 {
     List<String> users=new ArrayList<>();
   try(BufferedReader reader=new BufferedReader(new FileReader(new File(filename))))
        {
            String line=null;
            while((line=reader.readLine())!=null)
            {
                //System.out.println(Thread.currentThread().getName()+"Reading...."+line);
             users.add(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestUserProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
      return  users;
 }
}
