package com.tags.cs451r_groupproject_backend.student.model;

import lombok.Data;

import java.util.Comparator;

@Data
public class StudentComparator implements Comparator<Student> {
    private StudentSortingMethod studentSortingMethod;

    @Override
    public int compare(Student o1, Student o2) {
        return switch (studentSortingMethod) {
            case BY_ID -> Long.compare(o1.getId(), o2.getId());
            case BY_USERNAME -> o1.getUsername().compareTo(o2.getUsername());
        };
    }
}
