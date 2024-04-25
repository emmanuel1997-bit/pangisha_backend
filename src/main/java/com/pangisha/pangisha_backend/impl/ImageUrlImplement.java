package com.pangisha.pangisha_backend.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pangisha.pangisha_backend.model.ImageUrl;

import com.pangisha.pangisha_backend.repository.ImageUrlRepository;

import com.pangisha.pangisha_backend.service.ImageUrlService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
public class ImageUrlImplement implements ImageUrlService {
    ImageUrlRepository imageUrlRepository;
    private EntityManager entityManager;

    public ImageUrlImplement(ImageUrlRepository imageUrlRepository, EntityManager entityManager) {
        super();
        this.imageUrlRepository = imageUrlRepository;
        this.entityManager = entityManager;
    }

    @Override
    public ImageUrl saveImage(ImageUrl imageUrl) {
        return imageUrlRepository.save(imageUrl);
    }

    @Override
    public List<ImageUrl> getById(Long posId) {
        return imageUrlRepository.getByIds(posId);
    }

    @Override
    @Transactional
    public void deleteByPostId(long postId) {

        String nativeQuery = "DELETE FROM images WHERE post_id = :postId";
        Query query = entityManager.createNativeQuery(nativeQuery);
        query.setParameter("postId", postId);
        int rowsDeleted = query.executeUpdate();
        System.out.println("Rows deleted: " + rowsDeleted);
    }

}
