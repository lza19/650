package com.example.student.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "faculty")
public class FacultyEntity {


    @Id
    @GeneratedValue
    private Integer facultyId;
    private String facultyName;


    @OneToMany( mappedBy = "faculty" )
    private List<StudentEntity> Student;
}
