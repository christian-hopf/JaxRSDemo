package org.example.rest.service;

import org.example.rest.dao.MessageListDAO;
import org.example.rest.model.MessageList;
import org.jvnet.hk2.annotations.Service;

import java.util.List;

@Service
public class MessageListServiceImpl implements MessageListService {

    private MessageListDAO dao = MessageListDAO.getInstance();

    @Override
    public List<MessageList> getAllMessageLists() {
        return dao.listAll();
    }

    @Override
    public int createMessageList(MessageList msgList) {
        return dao.add(msgList);
    }

    @Override
    public MessageList getMessageListById(int id) {
        return dao.get(id);
    }

    @Override
    public boolean updateMessageListById(int id, MessageList msgList) {
        return dao.update(id, msgList);
    }

    @Override
    public boolean deleteMessageListById(int id) {
        return dao.deleteMessageListById(id);
    }
}
