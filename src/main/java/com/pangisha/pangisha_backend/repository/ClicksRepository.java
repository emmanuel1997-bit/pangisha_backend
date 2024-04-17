package com.pangisha.pangisha_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

import com.pangisha.pangisha_backend.model.Clicks;

public interface ClicksRepository extends JpaRepository<Clicks, Long> {
    @Query(value = "SELECT * FROM clicks l WHERE l.post_id=:postid  ", nativeQuery = true)
    List<Clicks> Clicks(Long postid);

}
