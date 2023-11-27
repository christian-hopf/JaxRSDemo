package org.example.resource;

import org.example.dao.MessageDAO;
import org.example.model.Message;
import org.example.model.MessagePostRequest;
import org.example.service.MessageService;
import org.example.service.MessageServiceImplementation;

import java.util.Map;
import java.util.HashMap;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/messages")
public class MessageResource {

//    @Inject
//    private MessageService messageService;

    private MessageDAO dao = MessageDAO.getInstance();

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
    public Response getAllMessages() {
        Map<Integer, String> messages = new HashMap<>();
//        for(Message m : messageService.getAllMessages()){
//            messages.put(m.getId(), m.getText());
//        }
        for (Message m : dao.listAll()) {
            messages.put(m.getId(), m.getText());
        }
        return Response.status(200).entity(messages).build();
    }

    // get message by id
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessageById(@NotNull @PathParam("id") int id) {
//        Message msg = messageService.getMessageById(id);
        Message msg = dao.get(id);
//        System.out.println(msg.toString());
//        return msg;
        return Response.status(200).entity(msg).build();
    }

    // posting a new message doesn't need path params
    // returns id of created message
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createMessage(@org.example.validators.MessagePostRequest MessagePostRequest request) {
//        int posted = messageService.createMessage(request);
        int posted = dao.add(request.getText());
        return Response.status(200).entity("Message created with id: " + posted).build();
    }

    //
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMessage(@NotNull @PathParam("id") int id, @org.example.validators.MessagePostRequest MessagePostRequest request) {
        boolean updated = dao.update(id, request.getText());
//        boolean updated = messageService.updateMessageById(id, request);
        return Response.status(200).entity("Message with id " + id + " successfully updated.").build();
    }

    //
    @DELETE
    @Path("/{id}")
    public Response deleteMessage(@NotNull @PathParam("id") int id) {
        boolean deleted = dao.deleteMessageById(id);
//        boolean deleted = messageService.deleteMessageById(id);
        return Response.status(200).entity("Message with id " + id + " successfully deleted.").build();
    }
}
