package com.tags.cs451r_groupproject_backend.student.rest;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long id) {
        super("Could not find student with id: " + id);
    }
}
