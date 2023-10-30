package com.tags.cs451r_groupproject_backend.application.rest;

import com.tags.cs451r_groupproject_backend.general.ErrorResponse;
import com.tags.cs451r_groupproject_backend.general.RestUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleNotFoundException(ApplicationNotFoundException e) {
        return RestUtils.generateBaseErrorResponseEntity(e, HttpStatus.NOT_FOUND);
    }

}
