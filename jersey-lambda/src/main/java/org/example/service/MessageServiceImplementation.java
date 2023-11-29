package org.example.service;

import org.example.dao.MessageDAO;
import org.example.dao.MessageListDAO;
import org.example.model.*;
import org.jvnet.hk2.annotations.Service;

import java.util.List;
import java.util.Map;

@Service
public class MessageServiceImplementation implements MessageService {

    private MessageListDAO dao = MessageListDAO.getInstance();

    @Override
    public List<MessageList> getAllMessageLists() {
        return dao.listAll();
    }

    @Override
    public int createMessageList(MessageListPostRequest request) {
        return dao.add(request);
    }

    @Override
    public MessageList getMessageListById(int id) {
        return dao.get(id);
    }

    @Override
    public boolean updateMessageListById(int id, MessageListUpdateRequest request) {
        return dao.update(id, request);
    }

    @Override
    public boolean deleteMessageListById(int id) {
        return dao.deleteMessageListById(id);
    }
}
