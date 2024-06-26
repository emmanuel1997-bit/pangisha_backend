package com.pangisha.pangisha_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private Object fieldvalue;

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldvalue) {
        super(String.format("%s not found with%s:%s", resourceName, fieldName, fieldvalue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldvalue = fieldvalue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldvalue() {
        return fieldvalue;
    }

}
