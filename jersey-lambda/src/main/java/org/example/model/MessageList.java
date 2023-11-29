package org.example.model;

import jakarta.validation.constraints.PositiveOrZero;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class MessageList {
    @NotNull
    @PositiveOrZero
    private int id;
    
    @Size(max = 5, message = "Maximum number of messages per MessageList is 5")
    private List<Message> messages;

    public MessageList() {
    }

    public MessageList(int id) {
        super();
        this.id = id;
    }

    public MessageList(int id, List<Message> messages) {
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

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
