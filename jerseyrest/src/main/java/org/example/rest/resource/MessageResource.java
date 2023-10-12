package org.example.rest.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.rest.model.Message;
import org.example.rest.service.MessageService;

import java.util.ArrayList;
import java.util.List;

@Path("/message")
public class MessageResource {
    @Inject
    private MessageService messageService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> hello() {
        return messageService.getMessages();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postHello(){

    }

    @Path("/{name}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@PathParam("name") String name) {
        return "Hello " + name;
    }

//    @Path("/hk2")
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String helloHK2() {
//        return messageService.getMessages();
//    }
}
