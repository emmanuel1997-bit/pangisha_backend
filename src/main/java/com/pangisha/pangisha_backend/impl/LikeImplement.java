package com.pangisha.pangisha_backend.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pangisha.pangisha_backend.model.Like;
import com.pangisha.pangisha_backend.repository.LikeRepository;
import com.pangisha.pangisha_backend.service.LikeService;

@Service
public class LikeImplement implements LikeService {
    final public LikeRepository likeRepository;

    public LikeImplement(LikeRepository likeRepository) {
        super();
        this.likeRepository = likeRepository;
    }

    @Override
    public int getLike(long postId) {

        List<Like> var = likeRepository.likes(postId);
        return var.size();

    }

    @Override
    public Like like(Like like) {
        return likeRepository.save(like);
    }

}
