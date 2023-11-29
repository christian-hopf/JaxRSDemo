package org.example.model;

import jakarta.validation.constraints.PositiveOrZero;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Message {
    @NotNull
    @PositiveOrZero
    private int id;

    @NotNull
    @Size(min = 1, max = 64, message = "Message can be a maximum of 64 characters")
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
