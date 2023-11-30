package org.example.rest.service;

import org.example.rest.model.MessageList;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface MessageListService {
    List<MessageList> getAllMessageLists();

    int createMessageList(MessageList msgList);

    MessageList getMessageListById(int id);

    boolean updateMessageListById(int id, MessageList msgList);

    boolean deleteMessageListById(int id);

}