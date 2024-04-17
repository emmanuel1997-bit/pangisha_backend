package com.pangisha.pangisha_backend.model;

import jakarta.persistence.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "sender_id", nullable = false)
    private long sender_id;
    @Column(name = "receive_id", nullable = false)
    private Long receive_id;
    @Column(name = "message")
    private String message;
    @Column(name = "time_sent", nullable = false)
    private String time_sent;
    @Column(name = "image", nullable = false)
    private boolean image;

}
