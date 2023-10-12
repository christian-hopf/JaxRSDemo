package org.example.rest.service;

import org.example.rest.model.Message;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

@Contract
public interface MessageService {
    List<Message> getMessages();

    void postMessage();
}
