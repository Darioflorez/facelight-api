package com.lab.serverdevelopment.resources;

import com.lab.serverdevelopment.ViewModels.MessageViewModel;
import com.lab.serverdevelopment.forms.MessageForm;
import com.lab.serverdevelopment.handlers.MessageHandler;
import com.lab.serverdevelopment.models.MessageType;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Dario on 2015-11-23.
 */

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {

    @GET
    public List<MessageViewModel> getMessages(@QueryParam("userId") Long userId,
                                              @QueryParam("type") MessageType type){
        if(userId != null && type != null){
            if(type.equals(MessageType.PUBLIC)){
                return MessageHandler.getPublicMessages(userId);
            }else if(type.equals(MessageType.PRIVATE)){
                return MessageHandler.getPrivateMessages(userId);
            }
            return null;
        }
        return null;
    }

    @GET
    @Path("{id}")
    public MessageViewModel getMessage(@PathParam("id") Long id){
        return null;
    }

    @POST
    public Boolean createdMessage(MessageForm user){
        return MessageHandler.createMessage(user);
    }

    @PUT
    @Path("{id}")
    public MessageViewModel updateMessage(@PathParam("id") Long id, MessageViewModel message){
        return null;
    }

    @DELETE
    @Path("{id}")
    public void deleteMessage(@PathParam("id") Long id){
        System.out.println("Message deleted!");
    }


}
