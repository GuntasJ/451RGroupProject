package com.tags.cs451r_groupproject_backend.general;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RestUtils {

    public static ResponseEntity<ErrorResponse> generateBaseErrorResponseEntity(Exception exception, HttpStatus httpStatus) {
        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setStatus(httpStatus.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, httpStatus);
    }
}
