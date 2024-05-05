package com.pangisha.pangisha_backend.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pangisha.pangisha_backend.service.PostUserImageService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable; // Import from the correct

@RestController
@RequestMapping("/userpostimage")
public class PostUserImageController {
    private final int pageSize = 10;
    public PostUserImageService service;

    PostUserImageController(PostUserImageService service

    ) {
        super();
        this.service = service;
    }

    @GetMapping("/allData/{page}")
    public String postVerified(@PathVariable("page") int page) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return service.allData(pageable);
    }
}
