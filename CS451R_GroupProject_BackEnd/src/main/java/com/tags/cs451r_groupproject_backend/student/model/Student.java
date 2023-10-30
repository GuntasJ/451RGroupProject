package com.tags.cs451r_groupproject_backend.student.model;


import com.tags.cs451r_groupproject_backend.general.Copier;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
public class Student implements Copier<Student> {
    @Id
    @Column(name = "student_id")
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Override
    public void copyFrom(Student entity) {
        this.id = entity.id;
        this.username = entity.username;
        this.password = entity.password;
    }
}
