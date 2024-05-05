package com.pangisha.pangisha_backend.service;

import java.util.List;

import com.pangisha.pangisha_backend.model.ImageUrl;

public interface ImageUrlService {
    public ImageUrl saveImage(ImageUrl imageUrl);

    public List<ImageUrl> getAll();

    public List<ImageUrl> getByPostId(Long Id);

    public void deleteByPostId(long postId);
}
