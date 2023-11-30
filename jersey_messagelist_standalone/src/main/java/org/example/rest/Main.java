package org.example.rest;

import org.example.rest.config.AutoScanFeature;
import org.example.rest.resource.MessageListResource;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    // we start at port 8080
    public static final String BASE_URI = "http://localhost:8080/";

    // Starts Grizzly HTTP server
    public static HttpServer startServer() {

        // scan packages
        final ResourceConfig config = new ResourceConfig().property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        config.packages(true, "org.example.rest");
        config.register(MessageListExceptionMapper.class);
        config.register(MessageListResource.class);

        // enable auto scan @Contract and @Service
        config.register(AutoScanFeature.class);

        LOGGER.info("Starting Server........");

        final HttpServer httpServer =
                GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), config);

        return httpServer;

    }

    public static void main(String[] args) {

        try {

            final HttpServer httpServer = startServer();

            // add jvm shutdown hook
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    System.out.println("Shutting down the application...");

                    httpServer.shutdownNow();

                    System.out.println("Done, exit.");
                } catch (Exception e) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
                }
            }));

            System.out.println(String.format("Application started.%nStop the application using CTRL+C"));

            // block and wait shut down signal, like CTRL+C
            Thread.currentThread().join();

        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}