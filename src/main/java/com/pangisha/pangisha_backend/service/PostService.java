package com.pangisha.pangisha_backend.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable; // Import from the correct package

import com.pangisha.pangisha_backend.model.Post;

public interface PostService {
    public Post postAdd(Post post);

    public Post updatePost(Long id, Post post);

    public void delete(Long id);

    public Page<Post> getAllPostHome(Pageable pageable);

    public Page<Post> getAllPostHomeByID(Pageable pageable, Long Id);

    public List<Post> getAllPostbyTypeAndlocation(String type, String region, String distric,
            String ward, Long userId);

    public List<Post> findAllverifiedbyId(boolean verified, Long userid);

}
