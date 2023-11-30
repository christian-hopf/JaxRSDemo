package org.example.rest.resource;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

import org.example.rest.model.MessageList;
import org.example.rest.service.MessageListService;

@Path("/messagelists")
public class MessageListResource {

    @Inject
    private MessageListService messageListService;

    // default get returns all messages
    @GET
    @Valid
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMessageLists() {
//        return messageListService.getAllMessageLists();
        return Response.status(200).entity(messageListService.getAllMessageLists()).build();
    }

    // get message by id
    @GET
    @Valid
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessageListById(@PathParam("id") int id) {
        //        System.out.println(msg.toString());
//        return messageListService.getMessageListById(id);
        MessageList msgList = messageListService.getMessageListById(id);
        if (msgList != null) {
            return Response.status(200).entity(msgList).build();
        }
        return Response.status(404).entity("Message list with id " + id + " not found.").build();
    }

    // posting a new message doesn't need path params
    // returns id of created message
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createMessageList(@Valid MessageList msgList) {
//        return messageListService.createMessageList(msgList);
        int posted = messageListService.createMessageList(msgList);
        return Response.status(200).entity("Message list created with id: " + posted).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMessageListById(@NotNull @PathParam("id") int id, @Valid MessageList msgList) {
//        return messageListService.updateMessageListById(id, msgList);
        boolean updated = messageListService.updateMessageListById(id, msgList);
//        boolean updated = messageService.updateMessageById(id, request);
        if (updated) {
            return Response.status(200).entity("Message list with id " + id + " successfully updated.").build();
        }
        return Response.status(404).entity("Message list with id " + id + " not found.").build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMessageListById(@NotNull @PathParam("id") int id) {
//        return messageListService.deleteMessageListById(id);
        boolean deleted = messageListService.deleteMessageListById(id);
//        boolean deleted = messageService.deleteMessageById(id);
        if (deleted) {
            return Response.status(200).entity("Message list with id " + id + " successfully deleted.").build();
        }
        return Response.status(404).entity("Message list with id " + id + " not found.").build();
    }
}