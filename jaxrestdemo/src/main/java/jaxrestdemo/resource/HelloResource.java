package jaxrestdemo.resource;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import jaxrestdemo.model.Hello;

@Path("hello")
public class HelloResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response sendHello() {
		Hello hello = new Hello("Hello user");
		return Response.ok(hello).build();
	}
}
