package com.tags.cs451r_groupproject_backend.position.rest;

import com.tags.cs451r_groupproject_backend.position.model.PositionId;

public class PositionNotFoundException extends RuntimeException {
    public PositionNotFoundException(PositionId id) {
        super("Could not find position with id: " + id);
    }
}
