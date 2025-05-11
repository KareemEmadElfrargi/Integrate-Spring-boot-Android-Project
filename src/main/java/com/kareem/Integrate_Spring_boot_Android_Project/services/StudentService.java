package com.kareem.Integrate_Spring_boot_Android_Project.services;

import com.kareem.Integrate_Spring_boot_Android_Project.model.Student;
import com.kareem.Integrate_Spring_boot_Android_Project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Optional<Student> getStudentById(int studentId) {
        return repository.findById(studentId);
    }

//    public void addStudent(Student student) {
//        repository.save(student);
//    }

    public void deleteStudentById(int id) {
        repository.deleteById(id);
    }

    public Student addOrUpdateStudent(Student student, MultipartFile imageBody) throws IOException {

        if (imageBody != null && !imageBody.isEmpty()) {
            student.setImageName(imageBody.getOriginalFilename());
            student.setImageData(imageBody.getBytes());
            student.setImageType(imageBody.getContentType());
        }
        return repository.save(student);

    }
}
