package com.tags.cs451r_groupproject_backend.filetransfer.rest;

public class FileNotFoundException extends RuntimeException {
    public FileNotFoundException(Long id) {
        super("File not found for id: " + id);
    }
}
