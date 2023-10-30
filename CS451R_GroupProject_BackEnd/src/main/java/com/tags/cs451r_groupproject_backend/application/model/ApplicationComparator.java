package com.tags.cs451r_groupproject_backend.application.model;

import lombok.Data;

import java.util.Comparator;

@Data
public class ApplicationComparator implements Comparator<Application> {
    private ApplicationSortingMethod applicationSortingMethod;

    @Override
    public int compare(Application o1, Application o2) {
        return switch (applicationSortingMethod) {
            case BY_ID -> Long.compare(o1.getId(), o2.getId());
            case BY_LAST_NAME -> o1.getLastName().compareTo(o2.getLastName());
            case BY_FIRST_NAME -> o1.getFirstName().compareTo(o2.getFirstName());
            case BY_STUDENT_ID -> Long.compare(o1.getStudentId(), o2.getStudentId());
            case BY_UMKC_MAIL -> o1.getUmkcEmail().compareTo(o2.getUmkcEmail());
            case BY_STANDING -> o1.getStanding().compareTo(o2.getStanding());
            case BY_GRADUATING_SEMESTER -> o1.getGraduatingSemester().compareTo(o2.getGraduatingSemester());
            case BY_UMKC_GPA -> Double.compare(o1.getUmkcGPA(), o2.getUmkcGPA());
            case BY_HOURS_DONE_AT_UMKC -> Long.compare(o1.getHoursDoneAtUmkc(), o2.getHoursDoneAtUmkc());
            case BY_UNDERGRADUATE_DEGREE -> o1.getUndergraduateDegree().compareTo(o2.getUndergraduateDegree());
            case BY_CURRENT_MAJOR -> o1.getCurrentMajor().compareTo(o2.getCurrentMajor());
            case BY_STUDENT_STATUS -> o1.getApplicationStatus().compareTo(o2.getApplicationStatus());
        };
    }
}
