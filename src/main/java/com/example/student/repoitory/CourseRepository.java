package com.example.student.repoitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student.entity.CousreEntity;

@Repository
public interface CourseRepository extends JpaRepository<CousreEntity,Integer>{
    
}
