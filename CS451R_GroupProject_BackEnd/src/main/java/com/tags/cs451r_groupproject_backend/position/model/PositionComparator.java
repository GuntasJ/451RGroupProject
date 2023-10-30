package com.tags.cs451r_groupproject_backend.position.model;

import lombok.Data;
import java.util.Comparator;

@Data
public class PositionComparator implements Comparator<Position> {
    private PositionSortingMethod positionSortingMethod;

    @Override
    public int compare(Position o1, Position o2) {
        return switch (positionSortingMethod) {
            case BY_DEGREE -> o1.getRequiredStanding().compareTo(o2.getRequiredStanding());
            case BY_POSITION_CLASS -> o1.getPositionClass().compareTo(o2.getPositionClass());
            case BY_NOTES -> o1.getNotes().compareTo(o2.getNotes());
            case BY_POSITION_TYPE -> o1.getPositionType().compareTo(o2.getPositionType());
            case BY_SEMESTER -> o1.getSemester().get(0).compareTo(o2.getSemester().get(0));
        };
    }
}
