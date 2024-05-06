package com.pangisha.pangisha_backend.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable; // Import from the correct package
import org.springframework.data.domain.PageRequest;

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
    @Autowired
    private PostService postService;

    private final int pageSize = 10;

    // this is post saving function
    @PostMapping("/save")
    public ResponseEntity<Post> savePost(@RequestBody Post Post) {
        var post = Post;
        post.setTime_posted(LocalDateTime.now());
        return new ResponseEntity<Post>(postService.postAdd(post),
                HttpStatus.CREATED);
    }

    @GetMapping("/{type}/{region}/{distric}/{ward}/{userid}")

    public List<Post> getPostBy(@PathVariable("type") String type,
            @PathVariable("region") String region, @PathVariable("distric") String distric,
            @PathVariable("ward") String ward, @PathVariable("userid") Long userId) {
        return postService.getAllPostbyTypeAndlocation(type, region, distric, ward, userId);
    }

    @GetMapping("/home/{page}")

    public Page<Post> postVerified(@PathVariable int page

    ) {

        Pageable pageable = PageRequest.of(page, pageSize);
        return postService.getAllPostHome(pageable);
    }

    @GetMapping("/home/{userid}/{verified}")
    public List<Post> findAllverifiedbyId(@PathVariable("userid") Long userid,
            @PathVariable("verified") boolean verified) {
        return postService.findAllverifiedbyId(verified, userid);

    }

    // UpdatePost
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
