package org.example.rest.model;

public class Message {
    private int id;
    private String text;

    public Message() {
    }

    public Message(int id){
        super();
        this.id = id;
    }

    public Message(int id, String text) {
        super();
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
