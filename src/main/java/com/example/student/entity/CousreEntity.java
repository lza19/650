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
@Table(name = "course")
public class CousreEntity {

    @GeneratedValue
    @Id
    private Integer courseId;
    private String courseName;
    private String courseDescription;

    @OneToMany(mappedBy = "course")
    private List<EnrollEntity> enrolls;
    
    
    
}