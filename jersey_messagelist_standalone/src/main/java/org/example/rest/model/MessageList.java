package org.example.rest.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.util.List;

public class MessageList {

    @NotNull
    @PositiveOrZero
    private int id;

    @NotNull
    @Size(min = 1, max = 5)
    private List<String> messageList;

    public MessageList() {
    }

    public MessageList(int id) {
        super();
        this.id = id;
    }

    public MessageList(int id, List<String> messageList) {
        this.id = id;
        this.messageList = messageList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<String> messageList) {
        this.messageList = messageList;
    }
}
