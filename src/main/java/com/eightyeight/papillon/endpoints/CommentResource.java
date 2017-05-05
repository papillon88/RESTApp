package com.eightyeight.papillon.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Created by papillon on 5/5/2017.
 */
@Path("/")
public class CommentResource {

    @GET
    public String test1(){
        return "test1";
    }

    @GET
    @Path("/{commentId}")
    public String test2(@PathParam("messageId") int messageId,
                        @PathParam("commentId") int commentId){
        return "commentId "+commentId+" for messageId "+messageId;
    }
}
