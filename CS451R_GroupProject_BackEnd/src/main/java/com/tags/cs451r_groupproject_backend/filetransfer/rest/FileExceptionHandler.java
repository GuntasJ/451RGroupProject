package com.tags.cs451r_groupproject_backend.filetransfer.rest;

import com.tags.cs451r_groupproject_backend.general.ErrorResponse;
import com.tags.cs451r_groupproject_backend.general.RestUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.io.IOException;

@RestControllerAdvice
public class FileExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleSizeException(MaxUploadSizeExceededException e) {
        return RestUtils.generateBaseErrorResponseEntity(e, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleIOException(IOException e) {
        return RestUtils.generateBaseErrorResponseEntity(e, HttpStatus.EXPECTATION_FAILED);
    }


}
