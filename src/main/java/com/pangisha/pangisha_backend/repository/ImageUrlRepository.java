package com.pangisha.pangisha_backend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pangisha.pangisha_backend.model.ImageUrl;

public interface ImageUrlRepository extends JpaRepository<ImageUrl, Long> {
    @Query(value = "SELECT * FROM images", nativeQuery = true)
    List<ImageUrl> getAll();

    @Query(value = "SELECT * FROM images i WHERE i.post_id=:post_id ", nativeQuery = true)
    List<ImageUrl> getByPostId(Long post_id);

}