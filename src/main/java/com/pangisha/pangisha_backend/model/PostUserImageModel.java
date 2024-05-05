package com.pangisha.pangisha_backend.model;

import lombok.Data;

@Data
public class PostUserImageModel {
    // user table
    private long user_id;
    private String first_name;
    private String last_name;
    private String phone_no;
    private String password;
    private String email;
    private String photo_url;
    // post table
    private long post_id;
    private String type;
    private String tittle;
    private String description;
    private String price_month;
    private String time_posted;
    private String payeach_time;
    private boolean verified;
    private String region;
    private String distric;
    private String ward;
    private String street;
    private String house_no;
    // imageurl table
    private Long image_id;
    private Long keyvariable;
    private String image_url;

}
