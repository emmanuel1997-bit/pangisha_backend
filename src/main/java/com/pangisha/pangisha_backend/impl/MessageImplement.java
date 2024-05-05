package com.pangisha.pangisha_backend.impl;

import java.util.ArrayList;
import java.util.List;
import com.pangisha.pangisha_backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pangisha.pangisha_backend.model.UserMessage;
import com.pangisha.pangisha_backend.model.Message;
import com.pangisha.pangisha_backend.repository.MessageRepository;
import com.pangisha.pangisha_backend.repository.UserRepository;
import com.pangisha.pangisha_backend.service.MessageService;

@Service
public class MessageImplement implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

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

        return messageRepository.messageFetch(sender);
    }

    public void process(Message message, UserMessage userMessage, Long id) {
        User user = userRepository.getUserId(id);
        userMessage.setFirst_name(user.getFirst_name());
        userMessage.setLast_name(user.getLast_name());
        userMessage.setId(message.getId());
        userMessage.setImage(message.isImage());
        userMessage.setPhoto_url(user.getPhoto_url());
        userMessage.setReceive_id(message.getReceive_id());
        userMessage.setSender_id(message.getSender_id());
        userMessage.setTime_sent(message.getTime_sent());
        userMessage.setMessage(message.getMessage());
    }

    @Override
    public List<UserMessage> messageFetch(Long sender) {
        List<UserMessage> allData = new ArrayList<>();
        List<Message> messages = messageRepository.messageFetch(sender);
        for (Message message : messages) {
            UserMessage userMessage = new UserMessage();
            process(message, userMessage, message.getReceive_id());
            allData.add(userMessage);
            // finished
        }
        return allData;
    }

    public List<Message> getMessagesBetweenUsers(long senderId, long receiverId) {
        return messageRepository.findBySenderIdAndReceiverIdOrSenderIdAndReceiverIdOrderByTimeSent(senderId, receiverId,
                receiverId, senderId);
    }

}
