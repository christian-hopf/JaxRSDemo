package org.example;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import javax.ws.rs.core.MediaType;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static org.junit.Assert.*;

@WireMockTest(httpsEnabled = true, httpsPort = 8443)
public class MessagesTest {
    static WireMockServer wireMockServer = new WireMockServer();

//    @BeforeAll
//    static void setUp() {
//        wireMockServer = new WireMockServer();
//        wireMockServer.start();
//        System.out.println("hi");
//    }
//
//    @AfterAll
//    static void stopWireMock() {
//        wireMockServer.stop();
//    }

    @Test
    public void testWireMock() {
        wireMockServer.start();
        System.out.println(wireMockServer.isRunning());
        System.out.println(wireMockServer.baseUrl());
        assertTrue(wireMockServer.isRunning());
    }

    @Test
    public void getAllMessagesTest() throws IOException, InterruptedException {
        final String allMessages = "{\"1\":\"Good morning\",\"2\":\"Good afternoon\",\"3\":\"Good evening\",\"4\":\"Good night\"}";
        wireMockServer.start();
        wireMockServer.stubFor(
                WireMock.get("/messages")
                        .willReturn(aResponse()
                                .withHeader("Content-Type", MediaType.APPLICATION_JSON)
                                .withBody(allMessages)));

        // create http client and GET request for localhost:8080/messages
        final HttpClient client = HttpClient.newBuilder().build();
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(wireMockServer.baseUrl() + "/messages"))
                .header("Content-Type", "application/json")
                .GET().build();

        // send request and store as response
        final HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        // test successful response
        assertEquals(200, response.statusCode());
        assertEquals(allMessages, response.body());
    }

    @Test
    public void getMessageByIdTest() throws IOException, InterruptedException {
        final String message2 = "{\"2\":\"Good afternoon\"}";
        wireMockServer.start();
        wireMockServer.stubFor(
                WireMock.get("/messages/2")
                        .willReturn(aResponse()
                                .withHeader("Content-Type", MediaType.APPLICATION_JSON)
                                .withBody(message2)));

        // create http client and GET request for localhost:8080/messages
        final HttpClient client = HttpClient.newBuilder().build();
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(wireMockServer.baseUrl() + "/messages/2"))
                .header("Content-Type", "application/json")
                .GET().build();

        // send request and store as response
        final HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        // test successful response
        assertEquals(200, response.statusCode());
        assertEquals(message2, response.body());
    }

    @Test
    public void postMessageTest() throws IOException, InterruptedException {
        final String postedMessage = "Message created with id: 5";
        wireMockServer.start();
        wireMockServer.stubFor(
                WireMock.post("/messages")
                        .willReturn(aResponse()
                                .withHeader("Content-Type", MediaType.APPLICATION_JSON)
                                .withBody(postedMessage)));

        // create http client and GET request for localhost:8080/messages
        final HttpClient client = HttpClient.newBuilder().build();
        final HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(URI.create(wireMockServer.baseUrl() + "/messages"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{\"text\":\"Wiremock POST test\"}")).build();

        // send request and store as response
        final HttpResponse<String> response =
                client.send(postRequest, HttpResponse.BodyHandlers.ofString());

        // test successful response
        assertEquals(200, response.statusCode());
        assertEquals(postedMessage, response.body());
    }

    @Test
    public void updateMessageTest() throws IOException, InterruptedException {
        final String updatedMessage = "Message with id 3 successfully updated.";
        wireMockServer.start();
        wireMockServer.stubFor(
                WireMock.put("/messages/3")
                        .willReturn(aResponse()
                                .withHeader("Content-Type", MediaType.APPLICATION_JSON)
                                .withBody(updatedMessage)));

        // create http client and GET request for localhost:8080/messages
        final HttpClient client = HttpClient.newBuilder().build();
        final HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(URI.create(wireMockServer.baseUrl() + "/messages/3"))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString("{\"text\":\"Wiremock UPDATE test\"}")).build();

        // send request and store as response
        final HttpResponse<String> response =
                client.send(postRequest, HttpResponse.BodyHandlers.ofString());

        // test successful response
        assertEquals(200, response.statusCode());
        assertEquals(updatedMessage, response.body());
    }

    @Test
    public void deleteMessageTest() throws IOException, InterruptedException {
        final String deletedMessage = "Message with id 3 successfully deleted.";
        wireMockServer.start();
        wireMockServer.stubFor(
                WireMock.delete("/messages/3")
                        .willReturn(aResponse()
                                .withHeader("Content-Type", MediaType.APPLICATION_JSON)
                                .withBody(deletedMessage)));

        // create http client and GET request for localhost:8080/messages
        final HttpClient client = HttpClient.newBuilder().build();
        final HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(URI.create(wireMockServer.baseUrl() + "/messages/3"))
                .header("Content-Type", "application/json")
                .DELETE().build();

        // send request and store as response
        final HttpResponse<String> response =
                client.send(postRequest, HttpResponse.BodyHandlers.ofString());

        // test successful response
        assertEquals(200, response.statusCode());
        assertEquals(deletedMessage, response.body());
    }


}
