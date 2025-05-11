package com.kareem.Integrate_Spring_boot_Android_Project.repository;

import com.kareem.Integrate_Spring_boot_Android_Project.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
