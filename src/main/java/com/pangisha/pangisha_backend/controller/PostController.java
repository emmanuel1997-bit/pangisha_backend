package com.pangisha.pangisha_backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pangisha.pangisha_backend.model.Post;
import com.pangisha.pangisha_backend.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
    final private PostService postService;

    public PostController(PostService postServices) {
        super();
        this.postService = postServices;
    }

    // save data to a database API
    @PostMapping("/save")
    public ResponseEntity<Post> savePost(@RequestBody Post Post) {
        return new ResponseEntity<Post>(postService.postAdd(Post),
                HttpStatus.CREATED);
    }

    @GetMapping("/{type}/{region}/{distric}/{ward}/{userid}")

    public List<Post> getPostBy(@PathVariable("type") String type,
            @PathVariable("region") String region, @PathVariable("distric") String distric,
            @PathVariable("ward") String ward, @PathVariable("userid") Long userId) {
        return postService.getAllPostbyTypeAndlocation(type, region, distric, ward, userId);
    }

    @GetMapping("/home/{verified}")
    public List<Post> postVerified(@PathVariable("verified") boolean verified) {

        return postService.getAllPostHome(verified);
    }

    @GetMapping("/home/{userid}/{verified}")
    public List<Post> findAllverifiedbyId(@PathVariable("userid") Long userid,
            @PathVariable("verified") boolean verified) {
        return postService.findAllverifiedbyId(verified, userid);

    }

    @PutMapping("/update/{id}")

    public ResponseEntity<Post> updatePost(@PathVariable("id") Long id, @RequestBody Post Posts) {

        return new ResponseEntity<Post>(postService.updatePost(id, Posts), HttpStatus.OK);
    }

    // delete by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        postService.delete(id);
        return new ResponseEntity<String>("ok it is deleted", HttpStatus.OK);
    }
}
