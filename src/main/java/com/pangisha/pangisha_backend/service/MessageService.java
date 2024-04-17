package com.pangisha.pangisha_backend.service;

import java.util.List;

import com.pangisha.pangisha_backend.model.Message;

public interface MessageService {

    public Message sendMessage(Message message);

    public List<Message> listMessage(Long sender, Long receiver);

    public List<Message> listMessageSendandReceived(Long sender);

}
