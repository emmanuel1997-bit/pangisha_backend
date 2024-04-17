package com.pangisha.pangisha_backend.impl;

import org.springframework.stereotype.Service;

import com.pangisha.pangisha_backend.model.ImageUrl;

import com.pangisha.pangisha_backend.repository.ImageUrlRepository;

import com.pangisha.pangisha_backend.service.ImageUrlService;

@Service
public class ImageUrlImplement implements ImageUrlService {
    ImageUrlRepository imageUrlRepository;

    public ImageUrlImplement(ImageUrlRepository imageUrlRepository) {
        super();
        this.imageUrlRepository = imageUrlRepository;
    }

    @Override
    public ImageUrl saveImage(ImageUrl imageUrl) {
        return imageUrlRepository.save(imageUrl);
    }

    @Override
    public ImageUrl getById(Long id, Long posId) {
        return imageUrlRepository.getByIds(id, posId);
    }

}
