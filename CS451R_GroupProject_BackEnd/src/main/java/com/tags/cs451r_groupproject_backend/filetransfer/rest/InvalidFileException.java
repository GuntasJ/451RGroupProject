package com.tags.cs451r_groupproject_backend.filetransfer.rest;

public class InvalidFileException extends RuntimeException {
    public InvalidFileException(String fileName) {
        super("File with name: " + fileName + "\ncannot have the data retrieved of it.");
    }
}
