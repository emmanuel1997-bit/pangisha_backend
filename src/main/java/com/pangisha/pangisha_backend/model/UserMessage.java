package com.pangisha.pangisha_backend.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserMessage {

    private long id;
    private String first_name;
    private String last_name;
    private String photo_url;
    private long sender_id;
    private Long receive_id;
    private String message;
    private LocalDateTime time_sent;
    private boolean image;
}
