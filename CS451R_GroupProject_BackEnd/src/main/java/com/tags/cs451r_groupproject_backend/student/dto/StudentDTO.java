package com.tags.cs451r_groupproject_backend.student.dto;

import com.tags.cs451r_groupproject_backend.general.Copier;
import com.tags.cs451r_groupproject_backend.student.model.Student;
import lombok.*;

@Data
@NoArgsConstructor
public class StudentDTO implements Copier<Student> {
    private Long id;
    private String username;

    public StudentDTO(Student student) {
        copyFrom(student);
    }

    @Override
    public void copyFrom(Student entity) {
        this.id = entity.getId();
        this.username = entity.getUsername();
    }
}
