package net.jaxdemo.resteasy.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;

import net.jaxdemo.resteasy.model.Message;

public class MessageService {
	private List<Message> messages = new ArrayList < Message > ();

    public List<Message> findAll() {
        messages.add(new Message(1, "Good morning"));
        messages.add(new Message(2, "Good afternoon"));
        messages.add(new Message(3, "Good night"));
        return messages;
    }

    public Message fetchBy(int id) throws NotFoundException {
        for (Message message: findAll()) {
            if (id == message.getId()) {
                return message;
            } else {
                throw new NotFoundException("Message with id " + id + " not found");
            }
        }
        return null;
    }

    public boolean create(Message Message) {
        return messages.add(Message);
    }

    public boolean update(Message message) {
        for (Message msg: messages) {
            if (message.getId() == (msg.getId())) {
                messages.remove(msg);
                messages.add(message);
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) throws NotFoundException {
        for (Message msg: messages) {
            if (msg.getId() == id) {
                messages.remove(msg);
                return true;
            }
        }
        return false;
    }
}
