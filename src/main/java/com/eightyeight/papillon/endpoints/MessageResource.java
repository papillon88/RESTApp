package com.eightyeight.papillon.endpoints;

import com.eightyeight.papillon.service.MessageService;
import com.eightyeight.papillon.dto.Message;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by papillon on 4/10/2017.
 */
@Path("/messages")
public class MessageResource {

    MessageService ms = new MessageService();

    @GET
    //@Produces(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages(){
        return ms.getAllMessages();
    }
    @GET
    @Path("/{messageId}")
    //@Produces(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("messageId") long messageId){
        return ms.getMessage(messageId);
    }


}
