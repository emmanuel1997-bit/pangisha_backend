package com.pangisha.pangisha_backend.service;

import java.util.List;

import com.pangisha.pangisha_backend.model.Message;
import com.pangisha.pangisha_backend.model.UserMessage;

public interface MessageService {

    public Message sendMessage(Message message);

    public List<Message> listMessage(Long sender, Long receiver);

    public List<Message> listMessageSendandReceived(Long sender);

    public List<UserMessage> messageFetch(Long id);

    public List<Message> getMessagesBetweenUsers(long senderId, long receiverId);

}
