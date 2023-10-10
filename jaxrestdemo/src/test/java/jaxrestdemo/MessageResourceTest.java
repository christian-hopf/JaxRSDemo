package jaxrestdemo;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.Test;

import net.jaxdemo.resteasy.model.Message;

public class MessageResourceTest {
    private static final String FULL_PATH = "http://localhost:8080/jaxrestdemo/rest/hello";

    @Test
    public void testGetMessages() {

        final ResteasyClient client = new ResteasyClientBuilder().build();
        final ResteasyWebTarget target = client
            .target(FULL_PATH);
        String response = target.request().get(String.class);
        System.out.println(response);
    }

    @Test
    public void testCreateMessage() {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(FULL_PATH);
        Response response = target.request()
            .post(Entity.entity(new Message(4, "Test message"), "application/json"));
        System.out.println(response.getStatus());
        response.close();
    }

    @Test
    public void testDeleteMessage() {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(FULL_PATH + "/1");
        Response response = target.request()
            .delete();
        System.out.println(response.getStatus());
        response.close();

        final ResteasyWebTarget target1 = client
            .target(FULL_PATH);
        String response1 = target1.request().get(String.class);
        System.out.println(response1);
    }

}
