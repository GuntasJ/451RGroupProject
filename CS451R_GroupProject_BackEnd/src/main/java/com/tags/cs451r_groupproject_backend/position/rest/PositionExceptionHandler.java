package com.tags.cs451r_groupproject_backend.position.rest;

import com.tags.cs451r_groupproject_backend.general.ErrorResponse;
import com.tags.cs451r_groupproject_backend.general.RestUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PositionExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleNotFoundException(PositionNotFoundException e) {
        return RestUtils.generateBaseErrorResponseEntity(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleAlreadyExistException(PositionAlreadyExistsException e) {
        return RestUtils.generateBaseErrorResponseEntity(e, HttpStatus.CONFLICT);
    }

}
