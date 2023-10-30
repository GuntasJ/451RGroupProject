package com.tags.cs451r_groupproject_backend.position.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
public class PositionId implements Serializable {
    private String positionClass;
    private String positionType;
    public PositionId(String positionClass, String positionType) {
        this.positionClass = positionClass;
        this.positionType = positionType;
    }
}
