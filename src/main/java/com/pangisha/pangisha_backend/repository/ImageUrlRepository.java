package com.pangisha.pangisha_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.pangisha.pangisha_backend.model.ImageUrl;

import jakarta.transaction.Transactional;

public interface ImageUrlRepository extends JpaRepository<ImageUrl, Long> {

    @Query(value = "SELECT * FROM images A WHERE A.post_id=:postId ", nativeQuery = true)
    List<ImageUrl> getByIds(Long postId);

}