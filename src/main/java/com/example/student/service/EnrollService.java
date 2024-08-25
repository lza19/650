package com.example.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.entity.EnrollEntity;
import com.example.student.repoitory.EnrollRepository;

@Service
public class EnrollService {

    @Autowired

    private EnrollRepository enrollRepository;

    public List<EnrollEntity> getEnrollAll(){
        return enrollRepository.findAll();
    }
    
    public EnrollEntity getEnrollid(Integer EnrollId){
        Optional<EnrollEntity> enroll = enrollRepository.findById(EnrollId);
        if ((enroll.isPresent())) {
            return enroll.get();
            
        }
        return null;
    }

    public EnrollEntity saveEnroll(EnrollEntity enrollEntity){
        EnrollEntity coruse = enrollRepository.save(enrollEntity);
        return coruse;

    }

    public void deleteEnrollId(Integer enrollId){
        enrollRepository.deleteById(enrollId);
    }
}
