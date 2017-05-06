package com.eightyeight.papillon.endpoints;

import com.eightyeight.papillon.service.MessageService;
import com.eightyeight.papillon.dto.Message;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by papillon on 4/10/2017.
 */
@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {

    private static final MessageService ms = new MessageService();

    @GET
    public List<Message> getMessages(@BeanParam MessageFilterBean messageFilterBean){
        if(messageFilterBean.getYear()>0)
            return ms.getAllMessagesForYear(messageFilterBean.getYear());
        if(messageFilterBean.getStart()>0 && messageFilterBean.getSize() > 0)
            return ms.getAllMessagesPaginated(messageFilterBean.getStart(),messageFilterBean.getSize());
        return ms.getAllMessages();
    }


    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") long messageId){
        return ms.getMessage(messageId);
    }

    @POST
    /*public List<Message> addMessage(Message message){

        return ms.addMessage(message);
    }*/
    public Response addMessage(@Context UriInfo uriinfo , Message message) throws URISyntaxException {
        Message msg = ms.addMessage(message);
        URI uri = uriinfo.getAbsolutePathBuilder().path(String.valueOf(msg.getId())).build();
        return Response.created(uri)
                .entity(msg)
                .build();
    }


    @PUT
    @Path("/{messageId}")
    public List<Message> updateMessage(@PathParam("messageId") long id, Message message){
        message.setId(id);
        return ms.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    public List<Message> deleteMessage(@PathParam("messageId") long id){
        return ms.removeMessage(id);
    }


    @Path("/{messageId}/comments")
    public CommentResource getCommentResource(){
        return new CommentResource();
    }

}
