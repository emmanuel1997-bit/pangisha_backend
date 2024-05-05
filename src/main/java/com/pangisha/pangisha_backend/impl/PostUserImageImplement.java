package com.pangisha.pangisha_backend.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable; // Import from the correct
import org.springframework.data.domain.PageRequest;
import org.springframework.cache.annotation.Cacheable;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.pangisha.pangisha_backend.model.ImageUrl;
import com.pangisha.pangisha_backend.model.Post;

import com.pangisha.pangisha_backend.service.ImageUrlService;
import com.pangisha.pangisha_backend.service.PostService;
import com.pangisha.pangisha_backend.service.PostUserImageService;
import com.pangisha.pangisha_backend.service.UserService;

@Service
public class PostUserImageImplement implements PostUserImageService {
    // @Autowired
    // public PostUserImageRepository data;
    @Autowired
    public PostService postService;
    @Autowired
    public UserService userService;
    @Autowired
    public ImageUrlService imageUrl;

    // @Override
    // public String interJoineddata() {
    // try {
    // // List<Object[]> resultList = data.interJoineddata();

    // ObjectMapper objectMapper = new ObjectMapper();
    // String json = objectMapper.writeValueAsString(resultList);
    // return json;
    // } catch (JsonProcessingException e) {
    // return null;
    // }

    // }

    @Override
    public String allData(Pageable pageable) {
        Page<Post> posts = postService.getAllPostHome(pageable);
        List<Map<String, Object>> allData = new ArrayList<>();
        ;

        for (Post post : posts) {

            Map<String, Object> allMap = new HashMap<>();
            long user_id = post.getUser_id();
            Long post_id = post.getPost_id();
            allMap.put("use_id", user_id);
            allMap.put("post_id", post_id);
            allMap.put("type", post.getType());
            allMap.put("tittle", post.getTittle());
            String description = post.getDescription();
            allMap.put("description", description);
            String price_month = post.getPrice_month();
            allMap.put("price_month", price_month);
            LocalDateTime time_posted = post.getTime_posted();
            allMap.put("time_posted", time_posted);
            String payeach_time = post.getPayeach_time();
            allMap.put("payeach_time", payeach_time);
            boolean verified = post.isVerified();
            allMap.put("verified ", verified);
            String region = post.getRegion();
            allMap.put("region", region);
            String distric = post.getDistric();
            allMap.put("distric", distric);
            String ward = post.getWard();
            allMap.put("ward", ward);
            String street = post.getWard();
            allMap.put("street", street);
            String house_no = post.getHouse_no();
            allMap.put("house_no", house_no);
            com.pangisha.pangisha_backend.model.User user = userService.getUserbyId(user_id);
            String first_name = user.getFirst_name();
            allMap.put("first_name", first_name);
            String last_name = user.getLast_name();
            allMap.put("last_name ", last_name);
            String phone_no = user.getPhone_no();
            allMap.put("phone_no", phone_no);
            String email = user.getEmail();
            allMap.put("email", email);
            String password = user.getPassword();
            allMap.put("password", password);
            String photo_url = user.getPhoto_url();
            allMap.put("photo_url", photo_url);
            List<ImageUrl> imagesUrls = imageUrl.getByPostId(post_id);
            for (var im = 0; im < imagesUrls.size(); im++) {
                Map<String, Object> imageMap = new HashMap<>();
                ImageUrl imagesUrl = imagesUrls.get(im);
                String url = imagesUrl.getImage_url();
                imageMap.put("url" + (im + 1), url);
                allMap.put("images", imageMap);
                if (im == imagesUrls.size() - 1) {

                    // imageMap.clear();
                }

            }

            allData.add(allMap);
        }

        Gson gson = new Gson();

        String json = gson.toJson(allData);
        return json;

    }

    public String getCachedData(int key) {
        int number = 10;
        Pageable pageable = PageRequest.of(key, number);
        return allData(pageable);
    }

}
