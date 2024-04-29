// package com.pangisha.pangisha_backend.impl;

// import java.net.http.HttpHeaders;

// import org.springframework.http.HttpEntity;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.client.RestTemplate;

// import com.pangisha.pangisha_backend.service.APIservice;

// public class APIserviceImplement implements APIservice {
// private final RestTemplate restTemplate = new RestTemplate();

// @Override
// public String postDataToExternalApi(String response) {
// String
// externalApiUrl="https://q66efkj8ke.execute-api.eu-north-1.amazonaws.com/dev/generate-presigned-url?key=$[response]"+response;

// HttpHeaders headers = new HttpHeaders(headers.);
// ;

// HttpEntity<String> requestEntity = new HttpEntity<>(requestData, headers);

// ResponseEntity<String> responseEntity =
// restTemplate.postForEntity(externalApiUrl, requestEntity, String.class);

// if (responseEntity.getStatusCode() == HttpStatus.OK) {
// return responseEntity.getBody();
// } else {
// return "Error: " + responseEntity.getStatusCodeValue();
// }
// }

// }
