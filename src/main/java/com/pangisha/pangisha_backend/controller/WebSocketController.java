package com.pangisha.pangisha_backend.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.pangisha.pangisha_backend.model.Message;
import com.pangisha.pangisha_backend.service.MessageService;

@Controller
public class WebSocketController {

    @Autowired
    private MessageService messageService;

    @MessageMapping("/chat/{senderId}/{receiverId}")
    @SendTo("/topic/messages/{receiverId}")
    public Message sendMessage(@DestinationVariable long senderId, @DestinationVariable long receiverId,
            Message message) {
        message.setTime_sent(LocalDateTime.now());
        return messageService.sendMessage(message);
    }
}
