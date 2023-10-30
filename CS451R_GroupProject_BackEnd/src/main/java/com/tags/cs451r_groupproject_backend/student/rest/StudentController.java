package com.tags.cs451r_groupproject_backend.student.rest;

import com.tags.cs451r_groupproject_backend.student.dto.StudentDTO;
import com.tags.cs451r_groupproject_backend.student.model.Student;
import com.tags.cs451r_groupproject_backend.student.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;
    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> retrieveAllStudents() {
         List<StudentDTO> studentDTOList = studentService.findAll()
                .stream()
                .map(StudentDTO::new)
                .toList();
         return new ResponseEntity<>(studentDTOList, HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDTO> retrieveStudent(@PathVariable Long id) {
        StudentDTO studentDTO = new StudentDTO(studentService.findById(id));
        return new ResponseEntity<>(studentDTO, HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity<StudentDTO> createStudent(@RequestBody Student student) {
        StudentDTO studentDTO = new StudentDTO(studentService.createStudent(student));
        return new ResponseEntity<>(studentDTO, HttpStatus.CREATED);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody Student student, @PathVariable Long id) {
        StudentDTO studentDTO = new StudentDTO(studentService.updateStudent(student, id));
        return new ResponseEntity<>(studentDTO, HttpStatus.OK);
    }

    @DeleteMapping("/students/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }



}
