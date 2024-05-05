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
    private Long image_id;

    @Column(name = "image_url", length = 255)
    private String image_url;

    @Column(name = "keyvariable")
    private String keyvariable;

    @Column(name = "post_id")
    private Long post_id;

    // Constructors, getters, setters
}
