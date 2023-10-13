package org.example.rest.service;

import org.example.rest.model.Message;
import org.example.rest.dao.MessageDAO;
import org.example.rest.model.MessagePostRequest;
import org.jvnet.hk2.annotations.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImplementation implements MessageService {

    private MessageDAO dao = MessageDAO.getInstance();

    @Override
    public List<Message> getAllMessages() {
        return dao.listAll();
    }

    @Override
    public int createMessage(MessagePostRequest request) {
        return dao.add(request.getText());
    }

    @Override
    public Message getMessageById(int id) {
        return dao.get(id);
    }

    @Override
    public boolean updateMessageById(int id, MessagePostRequest request){
        return dao.update(id, request.getText());
    }

    @Override
    public boolean deleteMessageById(int id) {
        return dao.deleteMessageById(id);
    }
}
