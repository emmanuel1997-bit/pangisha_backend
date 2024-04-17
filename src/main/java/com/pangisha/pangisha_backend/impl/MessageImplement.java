package com.pangisha.pangisha_backend.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pangisha.pangisha_backend.model.Message;
import com.pangisha.pangisha_backend.repository.MessageRepository;
import com.pangisha.pangisha_backend.service.MessageService;

@Service
public class MessageImplement implements MessageService {
    private final MessageRepository messageRepository;

    MessageImplement(MessageRepository messageRepository) {
        super();
        this.messageRepository = messageRepository;
    }

    @Override
    public Message sendMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public List<Message> listMessage(Long sender, Long receiver) {

        return messageRepository.ListMessages(sender, receiver);
    }

    @Override
    public List<Message> listMessageSendandReceived(Long sender) {
        return messageRepository.listMessageSendandReceived(sender);
    }

}
