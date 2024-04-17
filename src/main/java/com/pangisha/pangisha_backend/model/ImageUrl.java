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
@Table(name = "images")
public class ImageUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "post_id", nullable = false)
    private long post_id;
    @Column(name = "image_url1", nullable = false)
    private String image_url1;
    @Column(name = "image_url2")
    private String image_url2;
    @Column(name = "image_url3")
    private String image_url3;
    @Column(name = "image_url4")
    private String image_url4;
    @Column(name = "image_url5")
    private String image_url5;
    @Column(name = "image_url6")
    private String image_url6;
}
