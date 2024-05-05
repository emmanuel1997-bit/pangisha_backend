package com.pangisha.pangisha_backend.service;

import org.springframework.data.domain.Pageable; // Import from the correct package

public interface PostUserImageService {
    // public String interJoineddata();

    public String allData(Pageable pageable);
}
