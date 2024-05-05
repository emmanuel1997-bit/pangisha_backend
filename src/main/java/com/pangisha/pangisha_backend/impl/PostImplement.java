package com.pangisha.pangisha_backend.impl;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable; // Import from the correct package
import org.springframework.stereotype.Service;
import com.pangisha.pangisha_backend.exception.ResourceNotFoundException;
import com.pangisha.pangisha_backend.model.Post;

import com.pangisha.pangisha_backend.repository.PostRepository;
import com.pangisha.pangisha_backend.service.PostService;

@Service
public class PostImplement implements PostService {
    private final PostRepository postRepository;

    PostImplement(PostRepository postRepository) {
        super();
        this.postRepository = postRepository;
    }

    @Override
    public Post postAdd(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Long id, Post post) {

        Post existingPost = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        existingPost.setDescription(post.getDescription());
        existingPost.setType(post.getType());
        existingPost.setVerified(post.isVerified());
        existingPost.setPayeach_time(post.getPayeach_time());
        existingPost.setPrice_month(post.getPrice_month());
        existingPost.setTime_posted(post.getTime_posted());
        existingPost.setTittle(post.getTittle());
        existingPost.setType(post.getType());
        existingPost.setUser_id(post.getUser_id());
        existingPost.setDistric(post.getDistric());
        existingPost.setRegion(post.getRegion());
        existingPost.setStreet(post.getStreet());
        existingPost.setWard(post.getWard());
        postRepository.save(existingPost);
        return existingPost;

    }

    @Override
    public void delete(Long id) {

        postRepository.deleteById(id);
    }

    @Override
    public Page<Post> getAllPostHome(Pageable pageable) {

        return postRepository.findAllverified(pageable);
    }

    @Override
    public List<Post> getAllPostbyTypeAndlocation(String type, String region, String distric, String ward,
            Long userId) {

        return postRepository.getAllPostbyTypeAndlocation(type, region, distric, ward, userId);
    }

    @Override
    public List<Post> findAllverifiedbyId(boolean verified, Long userid) {
        return postRepository.findAllverifiedbyId(verified, userid);
    }

}
