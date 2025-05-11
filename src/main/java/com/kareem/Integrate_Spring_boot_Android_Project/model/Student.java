package com.kareem.Integrate_Spring_boot_Android_Project.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private int age;
    private String gender;
    private String imageName;
    private String imageType;
    @Lob
    private byte[] imageData;

    public Student(int id){
        this.id = id;
    }
}
