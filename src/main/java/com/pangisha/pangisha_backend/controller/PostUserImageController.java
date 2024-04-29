package com.pangisha.pangisha_backend.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pangisha.pangisha_backend.model.Like;
import com.pangisha.pangisha_backend.model.Post;
import com.pangisha.pangisha_backend.model.PostUserImageURLjoin;
import com.pangisha.pangisha_backend.service.PostUserImageService;

@RestController
@RequestMapping("/userpostimage")
public class PostUserImageController {

    public PostUserImageService service;

    PostUserImageController(PostUserImageService service

    ) {
        super();
        this.service = service;
    }

    @GetMapping()
    public List<PostUserImageURLjoin> findAllverifiedbyId() {
        return service.interJoineddata();

    }

}
