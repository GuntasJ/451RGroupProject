package com.tags.cs451r_groupproject_backend.student.rest;

import com.tags.cs451r_groupproject_backend.general.ErrorResponse;
import com.tags.cs451r_groupproject_backend.general.RestUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class StudentExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleNotFoundException(StudentNotFoundException e) {
        return RestUtils.generateBaseErrorResponseEntity(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleAlreadyExistsException(StudentAlreadyExistsException e) {
        return RestUtils.generateBaseErrorResponseEntity(e, HttpStatus.CONFLICT);
    }

}
