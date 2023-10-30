package com.tags.cs451r_groupproject_backend.student.service;

import com.tags.cs451r_groupproject_backend.filetransfer.model.File;
import com.tags.cs451r_groupproject_backend.filetransfer.repository.FileRepository;
import com.tags.cs451r_groupproject_backend.filetransfer.rest.FileNotFoundException;
import com.tags.cs451r_groupproject_backend.position.model.Position;
import com.tags.cs451r_groupproject_backend.position.respository.PositionRepository;
import com.tags.cs451r_groupproject_backend.student.model.Student;
import com.tags.cs451r_groupproject_backend.student.repository.StudentRepository;
import com.tags.cs451r_groupproject_backend.student.rest.StudentAlreadyExistsException;
import com.tags.cs451r_groupproject_backend.student.rest.StudentNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.orElseThrow(() -> new StudentNotFoundException(id));
    }

    public Student createStudent(Student student) {
        if(studentRepository.findByUsername(student.getUsername()) != null) {
            throw new StudentAlreadyExistsException(student.getUsername());
        }
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student, Long id) {
        return studentRepository.findById(id).map(student1 -> {
            student1.copyFrom(student);
            return studentRepository.save(student1);
        }).orElseThrow(() -> new StudentNotFoundException(id));
    }

    public void deleteStudent(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()) {
            studentRepository.delete(studentOptional.get());
        }
        else {
            throw new StudentNotFoundException(id);
        }
    }
}
