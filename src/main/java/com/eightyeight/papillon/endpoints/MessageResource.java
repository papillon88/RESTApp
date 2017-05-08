package com.eightyeight.papillon.endpoints;

import com.eightyeight.papillon.dto.Comment;
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
//@Produces(value = { MediaType.APPLICATION_JSON,MediaType.TEXT_XML } )
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

    private static final MessageService ms = new MessageService();

    @GET
    @Produces(value = { MediaType.APPLICATION_JSON } )
    public List<Message> getJSONMessages(@BeanParam MessageFilterBean messageFilterBean){
        if(messageFilterBean.getYear()>0)
            return ms.getAllMessagesForYear(messageFilterBean.getYear());
        if(messageFilterBean.getStart()>0 && messageFilterBean.getSize() > 0)
            return ms.getAllMessagesPaginated(messageFilterBean.getStart(),messageFilterBean.getSize());
        System.out.println("JSON method called");
        return ms.getAllMessages();
    }

    @GET
    @Produces(value = { MediaType.TEXT_XML } )
    public List<Message> getXMLMessages(@BeanParam MessageFilterBean messageFilterBean){
        if(messageFilterBean.getYear()>0)
            return ms.getAllMessagesForYear(messageFilterBean.getYear());
        if(messageFilterBean.getStart()>0 && messageFilterBean.getSize() > 0)
            return ms.getAllMessagesPaginated(messageFilterBean.getStart(),messageFilterBean.getSize());
        System.out.println("XML method called");
        return ms.getAllMessages();
    }


    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") long messageId,
                              @Context UriInfo uriInfo){
        Message msg = ms.getMessage(messageId);
        msg.addLinks(uriInfo.getBaseUriBuilder().path(MessageResource.class)
                .path(String.valueOf(msg.getId())).build().toString(),"self");
        msg.addLinks(uriInfo.getBaseUriBuilder().path(ProfileResource.class)
                .path(msg.getAuthor()).build().toString(),"profile");
        msg.addLinks(uriInfo.getBaseUriBuilder().path(MessageResource.class)
                .path(MessageResource.class,"getCommentResource")
                .path(CommentResource.class)
                .resolveTemplate("messageId",msg.getId())//used for substitution of values
                .build().toString(),"comments");
        return msg;
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
