package org.example.service;

import org.example.dao.MessageDAO;
import org.example.model.Message;
import org.example.model.MessagePostRequest;
import org.jvnet.hk2.annotations.Service;

import java.util.List;
import java.util.Map;

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
    public boolean updateMessageById(int id, MessagePostRequest request) {
        return dao.update(id, request.getText());
    }

    @Override
    public boolean deleteMessageById(int id) {
        return dao.deleteMessageById(id);
    }
}
