package com.pangisha.pangisha_backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pangisha.pangisha_backend.model.Like;
import com.pangisha.pangisha_backend.service.LikeService;

@RestController
@RequestMapping("/like")
public class LikeController {
    LikeService likeService;

    LikeController(LikeService likeService) {
        super();
        this.likeService = likeService;

    }

    @PostMapping()
    public ResponseEntity<Like> saveLike(@RequestBody Like Like) {
        return new ResponseEntity<Like>(likeService.like(Like),
                HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public int likes(@PathVariable("id") int id) {

        return likeService.getLike(id);
    }

}
