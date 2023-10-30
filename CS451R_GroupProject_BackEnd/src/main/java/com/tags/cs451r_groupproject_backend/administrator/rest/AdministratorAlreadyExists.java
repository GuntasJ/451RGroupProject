package com.tags.cs451r_groupproject_backend.administrator.rest;

public class AdministratorAlreadyExists extends RuntimeException {
    public AdministratorAlreadyExists(String username) {
        super("Administrator already exists with username: " + username);
    }
}
