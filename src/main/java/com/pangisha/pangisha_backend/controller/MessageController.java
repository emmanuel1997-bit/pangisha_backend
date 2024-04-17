package com.pangisha.pangisha_backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pangisha.pangisha_backend.model.Message;
import com.pangisha.pangisha_backend.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {
    final private MessageService MessageService;

    public MessageController(MessageService MessageServices) {
        super();
        this.MessageService = MessageServices;
    }

    // save data to a database API
    @PostMapping("/send")
    public ResponseEntity<Message> saveMessage(@RequestBody Message Message) {
        return new ResponseEntity<Message>(MessageService.sendMessage(Message),
                HttpStatus.CREATED);
    }

    // get all message sent and received from only specific person
    @GetMapping("/{sender}/{receiver}")
    public List<Message> ListMessage(@PathVariable("sender") Long sender, @PathVariable("receiver") Long receiver) {

        return MessageService.listMessage(sender, receiver);
    }

    @GetMapping("sender/{sender}")
    public List<Message> ListMessageSenderAndReceived(@PathVariable("sender") Long sender) {

        return MessageService.listMessageSendandReceived(sender);
    }

}
