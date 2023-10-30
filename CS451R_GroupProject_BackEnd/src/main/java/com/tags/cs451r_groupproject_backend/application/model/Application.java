package com.tags.cs451r_groupproject_backend.application.model;

import com.tags.cs451r_groupproject_backend.filetransfer.model.File;
import com.tags.cs451r_groupproject_backend.general.Copier;
import com.tags.cs451r_groupproject_backend.position.model.Position;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "application")
@Data
@NoArgsConstructor
public class Application implements Copier<Application> {
    @Id
    @GeneratedValue
    @Column(name = "application_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "umkc_email")
    private String umkcEmail;

    @Column(name = "standing")
    private String standing;

    @Column(name = "graduating_semester")
    private String graduatingSemester;

    @Column(name = "umkc_gpa")
    private Double umkcGPA;

    @Column(name = "hours_done_at_umkc")
    private Long hoursDoneAtUmkc;

    @Column(name = "undergraduate_degree")
    private String undergraduateDegree;

    @Column(name = "current_major")
    private String currentMajor;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ApplicationStatus applicationStatus = ApplicationStatus.PENDING;

    @ElementCollection
    @CollectionTable(name = "desired_class", joinColumns = @JoinColumn(name = "application_id"))
    @Column(name = "class_name")
    private List<String> desiredClasses;

    @ElementCollection
    @CollectionTable(name = "desired_type", joinColumns = @JoinColumn(name = "application_id"))
    @Column(name = "type")
    private List<String> desiredTypes;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id", referencedColumnName = "file_id")
    private File file;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}
    )
    @JoinTable(
            name = "applying",
            joinColumns = @JoinColumn(name = "application_id"),
            inverseJoinColumns = {@JoinColumn(name = "position_class"), @JoinColumn(name = "position_type")}
    )
    private List<Position> positions = new ArrayList<>();

    public void addPosition(Position position) {
        positions.add(position);
    }

    @Override
    public void copyFrom(Application entity) {
        this.firstName = entity.firstName;
        this.lastName = entity.lastName;
        this.studentId = entity.studentId;
        this.umkcEmail = entity.umkcEmail;
        this.standing = entity.standing;
        this.graduatingSemester = entity.graduatingSemester;
        this.umkcGPA = entity.umkcGPA;
        this.hoursDoneAtUmkc = entity.hoursDoneAtUmkc;
        this.undergraduateDegree = entity.undergraduateDegree;
        this.currentMajor = entity.currentMajor;
        this.applicationStatus = entity.applicationStatus;
        this.desiredClasses = entity.desiredClasses;
        this.desiredTypes = entity.desiredTypes;
    }
}
