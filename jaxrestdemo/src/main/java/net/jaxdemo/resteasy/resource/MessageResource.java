package net.jaxdemo.resteasy.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import net.jaxdemo.resteasy.model.Message;
import net.jaxdemo.resteasy.service.MessageService;

@Path("messages")
public class MessageResource {
	
	private MessageService messageService;
	
	// GET all messages
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {

        List<Message> messages = messageService.findAll();

        if (!messages.isEmpty()) {
            return Response.ok(messages).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
	
	// POST a new message
	@POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(Message message) {
        boolean createdMessage = messageService.create(message);
        if (createdMessage) {
            return Response.ok().status(Response.Status.CREATED).build();
        } else {
            return Response.notModified().build();
        }
    }
	
	// DELETE a message by id
	@Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("id") int id) {
        boolean deletedMessage = messageService.delete(id);

        if (deletedMessage) {
            return Response.ok().status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.notModified().build();
        }
    }

}
