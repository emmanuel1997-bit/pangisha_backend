package com.pangisha.pangisha_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pangisha.pangisha_backend.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT * FROM posts p WHERE p.type=:type OR p.region=:region OR p.distric=:distric OR p.ward=:ward OR p.user_id=:userid ", nativeQuery = true)
    List<Post> getAllPostbyTypeAndlocation(String type, String region, String distric, String ward, Long userid);

    @Query(value = "SELECT * FROM posts p WHERE p.verified=:verified ", nativeQuery = true)
    List<Post> findAllverified(boolean verified);

    @Query(value = "SELECT * FROM posts p WHERE p.verified=:verified AND p.user_id=:userid ", nativeQuery = true)
    List<Post> findAllverifiedbyId(boolean verified, Long userid);
}