package com.pangisha.pangisha_backend.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class PostUserImageURLjoin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    // user table
    private long user_id;
    private String first_name;
    private String last_name;
    private String phone_no;
    private String photo_url;
    private String email;
    // post table
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
    private String image_url;
    private String image_url1;
    private String image_url2;
    private String image_url3;
    private String image_url4;
    private String image_url5;

}
