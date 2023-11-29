package org.example.service;

import org.example.model.*;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface MessageService {
    //    List<Message> getAllMessages();
    List<MessageList> getAllMessageLists();

    //    int createMessage(MessagePostRequest request);
    int createMessageList(MessageListPostRequest request);

    //    Message getMessageById(int id);
    MessageList getMessageListById(int id);

    //    boolean updateMessageById(int id, MessagePostRequest request);
    boolean updateMessageListById(int id, MessageListUpdateRequest request);

    //    boolean deleteMessageById(int id);
    boolean deleteMessageListById(int id);
}
