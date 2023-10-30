package com.tags.cs451r_groupproject_backend.administrator.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@Data
public class AdministratorComparator implements Comparator<Administrator> {
    private AdministratorSortingMethod administratorSortingMethod;


    @Override
    public int compare(Administrator o1, Administrator o2) {
        return switch (administratorSortingMethod) {
            case BY_ID -> Long.compare(o1.getId(), o2.getId());
            case BY_USERNAME -> o1.getUsername().compareTo(o2.getUsername());
        };
    }
}
