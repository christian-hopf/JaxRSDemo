package org.example.rest.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.rest.model.Message;
import org.example.rest.model.MessagePostRequest;
import org.example.rest.service.MessageService;

import java.util.ArrayList;
import java.util.List;

@Path("/message")
public class MessageResource {
    @Inject
    private MessageService messageService;

    // default get returns all messages
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    // get message by id
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessageById(@PathParam("id") int id) {
        Message msg = messageService.getMessageById(id);
        System.out.println(msg.toString());
        return msg;
    }

    // posting a new message doesn't need path params
    // returns id of created message
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public int createMessage(MessagePostRequest request) {
        return messageService.createMessage(request);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean updateMessage(@PathParam("id") int id, MessagePostRequest request) {
        return messageService.updateMessageById(id, request);
    }

    @DELETE
    @Path("/{id}")
    public boolean deleteMessage(@PathParam("id") int id) {
        return messageService.deleteMessageById(id);
    }
}
