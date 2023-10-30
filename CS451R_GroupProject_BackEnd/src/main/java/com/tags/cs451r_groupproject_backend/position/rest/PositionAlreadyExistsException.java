package com.tags.cs451r_groupproject_backend.position.rest;

public class PositionAlreadyExistsException extends RuntimeException {
    public PositionAlreadyExistsException(String positionClass, String positionType) {
        super("Position already exists with (class/type): " + positionClass + ", " + positionType);
    }
}
