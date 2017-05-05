package com.eightyeight.papillon.endpoints;

import com.eightyeight.papillon.dto.Comment;
import com.eightyeight.papillon.dto.Message;
import com.eightyeight.papillon.service.CommentService;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by papillon on 5/5/2017.
 */
@Path("/")
public class CommentResource {

    private CommentService cs = new CommentService();

    @GET
    //@Produces(MediaType.APPLICATION_XML)
    public List<Comment> getAllComments(@PathParam("messageId") int messageId){
        return cs.getAllComments(messageId);
    }

    @GET
    @Path("/{commentId}")
    //@Produces(MediaType.APPLICATION_XML)
    public Comment getComment(@PathParam("commentId") int commentId,
                              @PathParam("messageId") int messageId){
        return cs.getComment(messageId,commentId);
    }

    @POST
    //@Produces(MediaType.APPLICATION_XML)
    public List<Comment> addComment(@PathParam("messageId") int messageId,Comment comment){
        return cs.addComment(messageId,comment);
    }

    @PUT
    @Path("/{commentId}")
    public List<Comment> updateComment(@PathParam("messageId") int messageId,
                                       @PathParam("commentId") int commentId,
                                       Comment comment){
        return cs.updateComment(messageId,commentId,comment);
    }

    @DELETE
    @Path("/{commentId}")
    public List<Comment> deleteComment(@PathParam("commentId") int commentId,
                              @PathParam("messageId") int messageId){
        return cs.removeComment(messageId,commentId);
    }

}
