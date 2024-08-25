package com.example.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.entity.StudentEntity;
import com.example.student.repoitory.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository StudentRepository;


    //SELECT * from student****
    public List<StudentEntity> getStudentAll(){
        return StudentRepository.findAll();
    }

    public StudentEntity getStudentById(Integer studentid){
        Optional<StudentEntity> student = StudentRepository.findById(studentid);
        if (student.isPresent()) {
            return student.get();
        }
        return null;
    }


    //insert //update
    public StudentEntity saveStudent(StudentEntity studentEntity){
        
        StudentEntity student = StudentRepository.save(studentEntity);
        return student;

    }

    public void deletestudent(Integer studentId){
        StudentRepository.deleteById(studentId);
    }


    
}
