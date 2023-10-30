package com.tags.cs451r_groupproject_backend.student.repository;

import com.tags.cs451r_groupproject_backend.administrator.model.Administrator;
import com.tags.cs451r_groupproject_backend.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.username = :username")
    Student findByUsername(@Param("username") String username);
}
