package org.example.dao;

import org.example.model.Message;
import org.example.model.MessageList;
import org.example.model.MessageListPostRequest;
import org.example.model.MessageListUpdateRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageListDAO {
    private static MessageListDAO instance;
    private static Map<Integer, MessageList> messageLists = new HashMap<>();
//    private static List<MessageList> messageLists = new ArrayList<>();


    static {
        Message msg1 = new Message(1, "Good morning");
        Message msg2 = new Message(2, "Good afternoon");
        Message msg3 = new Message(3, "Good evening");
        Message msg4 = new Message(4, "Good night");
        List<Message> list1 = new ArrayList<>();
        list1.add(msg1);
        list1.add(msg2);
        List<Message> list2 = new ArrayList<>();
        list2.add(msg2);
        list2.add(msg3);
        List<Message> list3 = new ArrayList<>();
        list3.add(msg3);
        list3.add(msg4);

        MessageList msgList1 = new MessageList(1, list1);
        MessageList msgList2 = new MessageList(2, list2);
        MessageList msgList3 = new MessageList(3, list3);

        messageLists.put(1, msgList1);
        messageLists.put(2, msgList2);
        messageLists.put(3, msgList3);
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
        List<MessageList> msgLists = new ArrayList<>();
        msgLists.addAll(messageLists.values());
        return msgLists;
    }

    public int add(MessageListPostRequest request) {
//        int id = messageLists.size() + 1;
        messageLists.put(request.getId(), new MessageList(request.getId(), request.getMessageList()));
        return request.getId();
    }

    // Assume unique IDs
    public MessageList get(int id) {
        if (messageLists.get(id) != null) {
            return messageLists.get(id);
        }
        return null;
    }

    public boolean update(int id, MessageListUpdateRequest request) {
        if (messageLists.get(id) != null) {
            messageLists.put(id, new MessageList(id, request.getMessageList()));
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
