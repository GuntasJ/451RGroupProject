package com.tags.cs451r_groupproject_backend.administrator.rest;

import com.tags.cs451r_groupproject_backend.general.ErrorResponse;
import com.tags.cs451r_groupproject_backend.general.RestUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdministratorExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleNotFoundException(AdministratorNotFoundException e) {
        return RestUtils.generateBaseErrorResponseEntity(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleAlreadyExistsException(AdministratorAlreadyExists e) {
        return RestUtils.generateBaseErrorResponseEntity(e, HttpStatus.CONFLICT);
    }


}
