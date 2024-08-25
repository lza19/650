package com.example.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.entity.FacultyEntity;
import com.example.student.repoitory.FacultyRepository;


@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    public List<FacultyEntity> getFacutyAll(){
        return facultyRepository.findAll();
    }

    public FacultyEntity getFacultyById(Integer Facultyid){
        Optional<FacultyEntity> faculty = facultyRepository.findById(Facultyid);
        if (faculty.isPresent()) {
            return faculty.get();
        }
        return null;
    }

    public FacultyEntity savefaculty(FacultyEntity facultyEntity){
        FacultyEntity faculty = facultyRepository.save(facultyEntity);
        return faculty;
    }

    public void deleteFacultyById(Integer facultyId){
        facultyRepository.deleteById(facultyId);
    }
    
}
