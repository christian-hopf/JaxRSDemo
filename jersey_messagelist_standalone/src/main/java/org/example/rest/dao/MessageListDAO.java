package org.example.rest.dao;

import org.example.rest.model.MessageList;

import java.util.*;

public class MessageListDAO {
    private static MessageListDAO instance;
    //    private static List<MessageList> messageLists = new ArrayList<>();
    private static Map<Integer, MessageList> messageLists = new HashMap<>();


    static {
        messageLists.put(1, (new MessageList(1, new ArrayList<>(Arrays.asList("Good morning", "Good afternoon")))));
        messageLists.put(2, (new MessageList(2, new ArrayList<>(Arrays.asList("Good afternoon", "Good evening")))));
        messageLists.put(3, (new MessageList(3, new ArrayList<>(Arrays.asList("Good evening", "Good night")))));
    }

    private MessageListDAO() {
    }

    public static MessageListDAO getInstance() {
        if (instance == null) {
            instance = new MessageListDAO();
        }
        return instance;
    }

    public List<MessageList> listAll() {
        return new ArrayList<MessageList>(messageLists.values());
    }

    public int add(MessageList msgList) {
        messageLists.put(msgList.getId(), msgList);
        return msgList.getId();
    }

    // Assume unique IDs
    public MessageList get(int id) {
        if (messageLists.get(id) != null) {
            return messageLists.get(id);
        }
        return null;
    }

    public boolean update(int id, MessageList msgList) {
        if (messageLists.get(id) != null) {
            messageLists.put(id, msgList);
            return true;
        }
        return false;
    }

    public boolean deleteMessageListById(int id) {
        if (messageLists.get(id) != null) {
            messageLists.remove(id);
            return true;
        }
        return false;
    }

}