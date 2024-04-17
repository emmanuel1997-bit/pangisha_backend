package com.pangisha.pangisha_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pangisha.pangisha_backend.model.ImageUrl;

public interface ImageUrlRepository extends JpaRepository<ImageUrl, Long> {

    @Query(value = "SELECT * FROM images A WHERE A.id=:id AND A.post_id=:postId ", nativeQuery = true)
    ImageUrl getByIds(Long id, Long postId);
}