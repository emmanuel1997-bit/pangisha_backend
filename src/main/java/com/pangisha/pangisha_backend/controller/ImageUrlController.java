package com.pangisha.pangisha_backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pangisha.pangisha_backend.model.ImageUrl;
import com.pangisha.pangisha_backend.service.ImageUrlService;

@RestController
@RequestMapping("/image")
public class ImageUrlController {
    private final ImageUrlService imageUrlService;

    public ImageUrlController(ImageUrlService imageUrlService) {
        super();
        this.imageUrlService = imageUrlService;
    }

    @PostMapping("/save")
    public ResponseEntity<ImageUrl> saveImage(@RequestBody ImageUrl ImageUrl) {
        return new ResponseEntity<ImageUrl>(imageUrlService.saveImage(ImageUrl),
                HttpStatus.CREATED);
    }

    @GetMapping("{id}/{postid}")
    public ResponseEntity<ImageUrl> getImageById(@PathVariable(value = "id") Long id,
            @PathVariable(value = "postid") Long postid) {
        return new ResponseEntity<ImageUrl>(imageUrlService.getById(id, postid), HttpStatus.OK);

    }

}
