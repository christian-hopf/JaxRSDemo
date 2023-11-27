package org.example.dao;

import org.example.model.Message;

import java.util.*;

public class MessageDAO {
    private static MessageDAO instance;
    private static Map<Integer, Message> messages = new HashMap<>();


    static {
        messages.put(1, (new Message(1, "Good morning")));
        messages.put(2, (new Message(2, "Good afternoon")));
        messages.put(3, (new Message(3, "Good evening")));
        messages.put(4, (new Message(4, "Good night")));
    }

    private MessageDAO() {
    }

    public static MessageDAO getInstance() {
        if (instance == null) {
            instance = new MessageDAO();
        }
        return instance;
    }

    public List<Message> listAll() {
        return new ArrayList<>(messages.values());
    }

    public int add(String text) {
        int id = messages.size() + 1;
        messages.put(id, (new Message(id, text)));
        return id;
    }

    // Assume unique IDs
    public Message get(int id) {
        if (id >= 1) {
            System.out.println(messages.get(id).toString());
            return messages.get(id);
        }
        return null;
    }

    public boolean update(int id, String text) {
        if (id >= 1) {
            messages.put(id, new Message(id, text));
            return true;
        }
        return false;
    }

    public boolean deleteMessageById(int id) {
        if (id >= 1) {
            messages.remove(id);
            return true;
        }
        return false;
    }

}
