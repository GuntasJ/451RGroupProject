package com.tags.cs451r_groupproject_backend.general;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BadRequestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleBadRequestException(Exception e) {
        return RestUtils.generateBaseErrorResponseEntity(e, HttpStatus.BAD_REQUEST);
    }
}
