package com.eightyeight.papillon.endpoints;

import com.eightyeight.papillon.service.MessageService;
import com.eightyeight.papillon.dto.Message;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by papillon on 4/10/2017.
 */
@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {

    MessageService ms = new MessageService();

    @GET
    //@Produces(MediaType.APPLICATION_XML)
    public List<Message> getMessages(@QueryParam("year") int year,@QueryParam("start") int start,@QueryParam("size") int size){
        if(year>0)
            return ms.getAllMessagesForYear(year);
        if(start>0 && size > 0)
            return ms.getAllMessagesPaginated(start,size);
        return ms.getAllMessages();
    }

    @GET
    @Path("/{messageId}")
    //@Produces(MediaType.APPLICATION_XML)
    public Message getMessage(@PathParam("messageId") long messageId){
        return ms.getMessage(messageId);
    }

    @POST
    //@Produces(MediaType.APPLICATION_XML)
    public List<Message> addMessage(Message message){
        return ms.addMessage(message);
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
}
