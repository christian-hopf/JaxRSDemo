package org.example.rest.service;

import org.example.rest.model.Message;
import org.jvnet.hk2.annotations.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImplementation implements MessageService{
    @Override
    public List<Message> getMessages() {
        List<Message> messages = new ArrayList<>();
        messages.add(new Message(1, "Good morning"));
        messages.add(new Message(2, "Good afternoon"));
        messages.add(new Message(3, "Good night"));
        return messages;
    }

    @Override
    public void postMessage() {
        return;
    }
}
