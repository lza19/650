package com.example.student.repoitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student.entity.FacultyEntity;

@Repository
public interface FacultyRepository extends JpaRepository<FacultyEntity,Integer>{
    
}
