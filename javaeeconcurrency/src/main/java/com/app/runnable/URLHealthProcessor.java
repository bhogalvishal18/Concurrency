/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.runnable;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vishal
 */
public class URLHealthProcessor implements Runnable {

    private static final String urlName = "https://www.google.com/";

    @Override
    public void run() {

        String statusOfApp = "";
        System.out.println(Thread.currentThread().getName()+"checking health of App!");
        try {
            URL url = new URL(urlName);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                statusOfApp = "Yes All Thinks Are working Fine!!";
            } else {
                statusOfApp = "No Something went wrong!!";
            }
            System.out.println("Status of App" + statusOfApp);
        } catch (MalformedURLException ex) {
            Logger.getLogger(URLHealthProcessor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(URLHealthProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
