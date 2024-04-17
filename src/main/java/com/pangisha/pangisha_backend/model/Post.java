package com.pangisha.pangisha_backend.model;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long post_id;
    @Column(name = "user_id", nullable = false)
    private long user_id;
    @Column(name = "type", nullable = false)
    private String type;
    @Column(name = "tittle", nullable = false)
    private String tittle;
    @Column(name = "description")
    private String description;
    @Column(name = "price_month", nullable = false)
    private String price_month;
    @Column(name = "time_posted", nullable = false)
    private String time_posted;
    @Column(name = "payeach_time", nullable = false)
    private String payeach_time;
    @Column(name = "verified", nullable = false)
    private boolean verified;
    @Column(name = "region", nullable = false)
    private String region;
    @Column(name = "distric", nullable = false)
    private String distric;
    @Column(name = "ward", nullable = false)
    private String ward;
    @Column(name = "street", nullable = false)
    private String street;
    @Column(name = "house_no")
    private String house_no;

}
