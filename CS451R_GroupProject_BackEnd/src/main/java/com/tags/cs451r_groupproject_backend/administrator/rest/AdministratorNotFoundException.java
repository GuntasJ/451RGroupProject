package com.tags.cs451r_groupproject_backend.administrator.rest;

public class AdministratorNotFoundException extends RuntimeException {
    public AdministratorNotFoundException(Long id) {
        super("Could not find administrator with id: " + id);
    }
}
