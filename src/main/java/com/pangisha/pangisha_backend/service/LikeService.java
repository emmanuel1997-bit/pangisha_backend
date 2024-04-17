package com.pangisha.pangisha_backend.service;

import com.pangisha.pangisha_backend.model.Like;

public interface LikeService {

    public int getLike(long postId);

    public Like like(Like userAction);
}
