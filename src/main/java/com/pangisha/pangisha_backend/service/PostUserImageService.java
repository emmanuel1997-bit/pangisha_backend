package com.pangisha.pangisha_backend.service;

import org.springframework.data.domain.Pageable; // Import from the correct package

public interface PostUserImageService {

    public String allDatawithID(Pageable pageable, Long Id);

    public String allData(Pageable pageable);
}
