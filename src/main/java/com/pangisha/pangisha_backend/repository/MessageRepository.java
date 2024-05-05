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

    @Query(value = "SELECT t1.sender_id, t1.receive_id, t1.message, t1.time_sent,t1.image,t1.id  " +
            "FROM messages t1 " +
            "WHERE (t1.sender_id = :id OR t1.receive_id = :id) " +
            "AND t1.time_sent = (SELECT MAX(t2.time_sent) " +
            "FROM messages t2 " +
            "WHERE (t1.sender_id = t2.sender_id AND t1.receive_id = t2.receive_id) "
            +
            "OR (t1.sender_id = t2.receive_id AND t1.receive_id = t2.sender_id))", nativeQuery = true)
    List<Message> messageFetch(Long id);

    @Query(value = "SELECT * FROM messages M " +
            "WHERE (M.sender_id =:senderId1 AND M.receive_id =:receiverId1) " +
            "OR (M.sender_id =:senderId2 AND M.receive_id =:receiverId2) " +
            "ORDER BY M.time_sent", nativeQuery = true)
    List<Message> findBySenderIdAndReceiverIdOrSenderIdAndReceiverIdOrderByTimeSent(
            long senderId1, long receiverId1, long senderId2, long receiverId2);
}
