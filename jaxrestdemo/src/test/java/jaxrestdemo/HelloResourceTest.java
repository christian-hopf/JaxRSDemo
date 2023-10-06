package jaxrestdemo;

import static org.junit.Assert.*;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.Test;

public class HelloResourceTest {

	@Test
	public void testHello() {
		final ResteasyClient client = new ResteasyClientBuilder().build();
        final ResteasyWebTarget target = client.target("http://localhost:8080/jaxrestdemo/rest/hello");
        String response = target.request().get(String.class);
        System.out.println(response);
	}

}
