package com.pangisha.pangisha_backend.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.pangisha.pangisha_backend.model.PostUserImageURLjoin;
import com.pangisha.pangisha_backend.repository.PostUserImageRepository;
import com.pangisha.pangisha_backend.service.PostUserImageService;

@Service

public class PostUserImageImplement implements PostUserImageService {
    public PostUserImageRepository data;

    PostUserImageImplement(PostUserImageRepository data) {
        super();
        this.data = data;
    }

    @Override
    public List<PostUserImageURLjoin> interJoineddata() {
        return data.getAllInterjoin();
    }

}
