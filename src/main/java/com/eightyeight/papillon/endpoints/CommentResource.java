package com.eightyeight.papillon.endpoints;

import com.eightyeight.papillon.dto.Comment;
import com.eightyeight.papillon.dto.Message;
import com.eightyeight.papillon.service.CommentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by papillon on 5/5/2017.
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

    private static final CommentService cs = new CommentService();

    @GET
    //@Produces(MediaType.APPLICATION_XML)
    public List<Comment> getAllComments(@PathParam("messageId") long messageId){
        return cs.getComments(messageId);
    }

    @GET
    @Path("/{commentId}")
    //@Produces(MediaType.APPLICATION_XML)
    public Comment getComment(@PathParam("commentId") long commentId,
                              @PathParam("messageId") long messageId){
        return cs.getComment(messageId,commentId);
    }

    @POST
    //@Produces(MediaType.APPLICATION_XML)
    public List<Comment> addComment(@PathParam("messageId") long messageId,Comment comment){
        return cs.addComment(messageId,comment);
    }

    @PUT
    @Path("/{commentId}")
    public List<Comment> updateComment(@PathParam("messageId") long messageId,
                                       @PathParam("commentId") long commentId,
                                       Comment comment){
        return cs.updateComment(messageId,commentId,comment);
    }

    @DELETE
    @Path("/{commentId}")
    public List<Comment> deleteComment(@PathParam("commentId") long commentId,
                              @PathParam("messageId") long messageId){
        return cs.removeComment(messageId,commentId);
    }

}
