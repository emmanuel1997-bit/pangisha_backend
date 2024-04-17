package com.pangisha.pangisha_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pangisha.pangisha_backend.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
    @Query(value = "SELECT * FROM messages p WHERE (p.sender_id=:sender AND p.receive_id=:receiver) OR(p.sender_id=:receiver AND p.receive_id=:sender) ", nativeQuery = true)
    List<Message> ListMessages(Long sender, Long receiver);

    @Query(value = "SELECT * FROM messages p WHERE  p.sender_id=:sender OR p.receive_id=:sender GROUP BY p.sender_id HAVING COUNT(*) >1  ", nativeQuery = true)
    List<Message> listMessageSendandReceived(Long sender);
}
