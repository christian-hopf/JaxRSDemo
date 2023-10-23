package org.example.service;

import org.example.model.Message;
import org.example.model.MessagePostRequest;
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
