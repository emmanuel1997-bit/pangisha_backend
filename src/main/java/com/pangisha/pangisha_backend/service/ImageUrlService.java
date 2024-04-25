package com.pangisha.pangisha_backend.service;

import java.util.List;

import com.pangisha.pangisha_backend.model.ImageUrl;

public interface ImageUrlService {
    public ImageUrl saveImage(ImageUrl imageUrl);

    public List<ImageUrl> getById(Long posId);

    public void deleteByPostId(long postId);
}
