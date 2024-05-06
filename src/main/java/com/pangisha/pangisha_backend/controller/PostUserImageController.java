package com.pangisha.pangisha_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pangisha.pangisha_backend.service.PostUserImageService;

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
    public String GetAllData(@PathVariable("page") int page) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return service.allData(pageable);
    }

    @GetMapping("/allData/{id}/{page}")
    public String GetAlldatabyID(@PathVariable("page") int page, @PathVariable("id") Long id) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return service.allDatawithID(pageable, id);
    }
}

// this is home pageview data and listing post data its now completed