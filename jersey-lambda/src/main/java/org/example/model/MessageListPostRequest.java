package org.example.model;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


public class MessageListPostRequest {
    @NotNull
    @PositiveOrZero
    private int id;

    @NotNull
    @Size(min = 1, max = 5, message = "MessageList maximum length is 5 messages")
    private List<Message> messages;

    public MessageListPostRequest() {
    }

    public MessageListPostRequest(int id, List<Message> messages) {
        super();
        this.id = id;
        this.messages = messages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Message> getMessageList() {
        return messages;
    }

    public void setMessageList(List<Message> messages) {
        this.messages = messages;
    }
}
