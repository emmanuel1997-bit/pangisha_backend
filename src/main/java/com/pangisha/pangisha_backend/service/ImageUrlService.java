package com.pangisha.pangisha_backend.service;

import com.pangisha.pangisha_backend.model.ImageUrl;

public interface ImageUrlService {
    public ImageUrl saveImage(ImageUrl imageUrl);

    public ImageUrl getById(Long id, Long posId);

}
