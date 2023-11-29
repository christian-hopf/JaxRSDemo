package org.example.model;

import java.util.List;

public class MessageListUpdateRequest {
    private List<Message> messages;

    public MessageListUpdateRequest() {
    }

    public MessageListUpdateRequest(List<Message> messages) {
        super();
        this.messages = messages;
    }

    public List<Message> getMessageList() {
        return messages;
    }

    public void setMessageList(List<Message> messages) {
        this.messages = messages;
    }
}
