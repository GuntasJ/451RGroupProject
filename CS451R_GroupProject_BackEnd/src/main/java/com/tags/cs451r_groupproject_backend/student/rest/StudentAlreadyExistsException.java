package com.tags.cs451r_groupproject_backend.student.rest;

public class StudentAlreadyExistsException extends RuntimeException {
    public StudentAlreadyExistsException(String username) {
        super("Student already exists with username: " + username);
    }
}
