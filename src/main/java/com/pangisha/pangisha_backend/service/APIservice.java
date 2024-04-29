package com.pangisha.pangisha_backend.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface APIservice {
     public String postDataToExternalApi(String response);
}
