package com.pangisha.pangisha_backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pangisha.pangisha_backend.model.Clicks;
import com.pangisha.pangisha_backend.service.ClicksService;

@RestController
@RequestMapping("/clicks")
public class ClicksController {
    ClicksService ClicksService;

    ClicksController(ClicksService clicksService) {
        super();
        this.ClicksService = clicksService;

    }

    @PostMapping()
    public ResponseEntity<Clicks> saveLike(@RequestBody Clicks Like) {
        return new ResponseEntity<Clicks>(ClicksService.click(Like),
                HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public int likes(@PathVariable("id") int id) {

        return ClicksService.getClicks(id);
    }

}