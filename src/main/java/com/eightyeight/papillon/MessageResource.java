package com.eightyeight.papillon;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by papillon on 4/10/2017.
 */
@Path("/messages")
public class MessageResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessages(){
        return "Hello World from messages";
    }
}
