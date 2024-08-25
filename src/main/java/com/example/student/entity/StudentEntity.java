package com.example.student.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "student")
public class StudentEntity {


    @Id
    @GeneratedValue
    private Integer studentId;
    private String studentCode;
    private String studentFirstname;
    private String studentLastName;
    //private String facultyId;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private FacultyEntity faculty;

    @OneToMany(mappedBy = "student")
    private List<EnrollEntity> enrolls;
}
