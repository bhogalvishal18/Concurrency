/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author Vishal
 */
@Path("greetUser")
public class GreetResource {
    @GET
    @Path("hello")
    public String greeuser()
    {
        return "Java EE Concurrency";
    }
}
