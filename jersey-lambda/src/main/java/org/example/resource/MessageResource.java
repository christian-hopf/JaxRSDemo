package org.example.resource;

import org.example.dao.MessageDAO;
import org.example.dao.MessageListDAO;
import org.example.model.*;
import org.example.service.MessageService;
import org.example.service.MessageServiceImplementation;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.validation.*;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;

import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/messages")
public class MessageResource {

//    @Inject
//    private MessageService messageService;

    private MessageListDAO dao = MessageListDAO.getInstance();

//    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.WILDCARD)
//    public Response getAllMessages() {
//        Map<String, String> pong = new HashMap<>();
//        pong.put("pong", "Hello, World!");
//        return Response.status(200).entity(pong).build();
//    }

    // default get returns all messages
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.WILDCARD)
    public Response getAllMessageLists() {
        return Response.status(200).entity(dao.listAll()).build();
    }

    // get message by id
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessageListById(@NotNull @PathParam("id") int id) {
        MessageList msgList = dao.get(id);
        if (msgList != null) {
            return Response.status(200).entity(msgList).build();
        }
        return Response.status(404).entity("Message list with id " + id + " not found.").build();
    }

    // posting a new message doesn't need path params
    // returns id of created message
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createMessage(@Valid MessageListPostRequest request) {
//        Set<ConstraintViolation<MessageListPostRequest>> violations = validator.validate(request);
//        // if the request is not valid, throw bad request
//        if (!violations.isEmpty()){
//            // log errors
//
//            return Response.status(400).entity("Error 400 bad request").build();
//        }
        // if the request is valid, add the request and return 200 response
        int posted = dao.add(request);
        return Response.status(200).entity("Message list created with id: " + posted).build();
    }

    //
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMessage(@PathParam("id") int id, MessageListUpdateRequest request) {
        boolean updated = dao.update(id, request);
//        boolean updated = messageService.updateMessageById(id, request);
        if (updated) {
            return Response.status(200).entity("Message list with id " + id + " successfully updated.").build();
        }
        return Response.status(404).entity("Message list with id " + id + " not found.").build();
    }

    //
    @DELETE
    @Path("/{id}")
    public Response deleteMessageListById(@PathParam("id") int id) {
        boolean deleted = dao.deleteMessageListById(id);
//        boolean deleted = messageService.deleteMessageById(id);
        if (deleted) {
            return Response.status(200).entity("Message list with id " + id + " successfully deleted.").build();
        }
        return Response.status(404).entity("Message list with id " + id + " not found.").build();
    }
}
