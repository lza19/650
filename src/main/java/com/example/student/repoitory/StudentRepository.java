package com.example.student.repoitory;

import org.springframework.stereotype.Repository;
import com.example.student.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {
    


}
