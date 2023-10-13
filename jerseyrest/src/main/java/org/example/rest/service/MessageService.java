package org.example.rest.service;

import org.example.rest.model.Message;
import org.example.rest.model.MessagePostRequest;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface MessageService {
    List<Message> getAllMessages();

    int createMessage(MessagePostRequest request);

    Message getMessageById(int id);

    boolean updateMessageById(int id, MessagePostRequest request);

    boolean deleteMessageById(int id);

}
