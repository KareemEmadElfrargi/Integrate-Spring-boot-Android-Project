package com.kareem.Integrate_Spring_boot_Android_Project.controller;

import com.kareem.Integrate_Spring_boot_Android_Project.model.Student;
import com.kareem.Integrate_Spring_boot_Android_Project.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("/students")
    public ResponseEntity<?> getAllStudent() {
        List<Student> students = service.getAllStudents();
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<?> getStudentById(@PathVariable int studentId) {
        Optional<Student> studentOptional = service.getStudentById(studentId);

        if (studentOptional.isEmpty()) {
            return new ResponseEntity<>("Student with id '" + studentId + "' Not Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(studentOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/student")
    public ResponseEntity<String> addStudent(@RequestPart("student") Student student, @RequestPart("ImageFile") MultipartFile imageFile) throws IOException {
        Student addedStudent = service.addOrUpdateStudent(student, imageFile);
        return new ResponseEntity<>("Student " + student.getName() + " Saved Successfully", HttpStatus.OK);

    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable int id) {
        Optional<Student> studentOptional = service.getStudentById(id);

        if (studentOptional.isPresent()) {
            service.deleteStudentById(id);
            return new ResponseEntity<>("Student with ID " + id + " Deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student with ID " + id + " not found to delete.", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id, @RequestPart("student") Student studentBody, @RequestPart("ImageFile") MultipartFile imageFile) {
        Student fetchUpdateStudent = null;
        try {
            fetchUpdateStudent = service.getStudentById(id).orElse(null);
            if (fetchUpdateStudent == null) {
                return new ResponseEntity<>("Student with id " + id + " not found!", HttpStatus.NOT_FOUND);
            }

            fetchUpdateStudent.setName(studentBody.getName());
            System.out.println(studentBody.getName());
            fetchUpdateStudent.setAge(studentBody.getAge());
            fetchUpdateStudent.setEmail(studentBody.getEmail());
            fetchUpdateStudent.setGender(studentBody.getGender());

            Student updatedStudent = service.addOrUpdateStudent(fetchUpdateStudent, imageFile);

            return new ResponseEntity<>("Updated Successfully.\n" + fetchUpdateStudent, HttpStatus.OK);

        } catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }


}
