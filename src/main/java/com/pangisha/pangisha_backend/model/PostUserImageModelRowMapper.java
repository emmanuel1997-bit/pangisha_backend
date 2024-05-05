package com.pangisha.pangisha_backend.model;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostUserImageModelRowMapper implements RowMapper<PostUserImageModel> {

    @Override
    public PostUserImageModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        PostUserImageModel postUserImageModel = new PostUserImageModel();

        // User table fields
        postUserImageModel.setUser_id(rs.getLong("user_id"));
        postUserImageModel.setFirst_name(rs.getString("first_name"));
        postUserImageModel.setLast_name(rs.getString("last_name"));
        postUserImageModel.setPhone_no(rs.getString("phone_no"));
        postUserImageModel.setPassword(rs.getString("password"));
        postUserImageModel.setEmail(rs.getString("email"));
        postUserImageModel.setPhoto_url(rs.getString("photo_url"));

        // Post table fields
        postUserImageModel.setPost_id(rs.getLong("post_id"));
        postUserImageModel.setType(rs.getString("type"));
        postUserImageModel.setTittle(rs.getString("tittle"));
        postUserImageModel.setDescription(rs.getString("description"));
        postUserImageModel.setPrice_month(rs.getString("price_month"));
        postUserImageModel.setTime_posted(rs.getString("time_posted"));
        postUserImageModel.setPayeach_time(rs.getString("payeach_time")); // Make sure this matches your column name

        // Additional Post table fields
        postUserImageModel.setVerified(rs.getBoolean("verified"));
        postUserImageModel.setRegion(rs.getString("region"));
        postUserImageModel.setDistric(rs.getString("distric")); // Make sure this matches your column name
        postUserImageModel.setWard(rs.getString("ward"));
        postUserImageModel.setStreet(rs.getString("street"));
        postUserImageModel.setHouse_no(rs.getString("house_no"));

        // ImageUrl table fields
        postUserImageModel.setImage_id(rs.getLong("image_id"));
        postUserImageModel.setImage_url(rs.getString("image_url"));

        return postUserImageModel;
    }
}
