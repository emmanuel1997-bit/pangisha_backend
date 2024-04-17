package com.pangisha.pangisha_backend.service;

import java.util.List;

import com.pangisha.pangisha_backend.model.Post;

public interface PostService {
    public Post postAdd(Post post);

    public Post updatePost(Long id, Post post);

    public void delete(Long id);

    public List<Post> getAllPostHome(boolean verified);

    public List<Post> getAllPostbyTypeAndlocation(String type, String region, String distric,
            String ward, Long userId);

    public List<Post> findAllverifiedbyId(boolean verified, Long userid);
}
