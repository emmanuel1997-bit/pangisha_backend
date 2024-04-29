package com.pangisha.pangisha_backend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pangisha.pangisha_backend.model.ImageUrl;
import com.pangisha.pangisha_backend.model.PostUserImageURLjoin;

public interface PostUserImageRepository extends JpaRepository<PostUserImageURLjoin, Long> {

    @Query(value = "SELECT users.user_id,users.first_name,posts.region,images.image_url " +
            "FROM users A" +
            " JOIN posts B ON A.user_id=B.user_id " +
            " JOIN images C ON B.post_id=C.post_id;", nativeQuery = true)

    List<PostUserImageURLjoin> getAllInterjoin();

}