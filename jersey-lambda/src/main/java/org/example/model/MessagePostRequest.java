package org.example.model;

import org.glassfish.jersey.server.JSONP;

public class MessagePostRequest {
    private String text;

    public MessagePostRequest() {
    }

    public MessagePostRequest(String text) {
        super();
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
