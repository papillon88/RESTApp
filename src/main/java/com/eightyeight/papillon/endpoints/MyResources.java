package com.eightyeight.papillon.endpoints;


/**
 * Created by papillon on 4/9/2017.
 */


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/myresources")
public class MyResources {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayhello() {
        return "hello world from myresources";
    }

}