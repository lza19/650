package com.example.student.repoitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student.entity.EnrollEntity;

@Repository
public interface EnrollRepository extends JpaRepository<EnrollEntity,Integer> {
    
}
