package com.example.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.entity.CousreEntity;
import com.example.student.repoitory.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<CousreEntity> getCourseAll() {
        return courseRepository.findAll();
    }

    public CousreEntity getCourseById(Integer courseId) {
        Optional<CousreEntity> course = courseRepository.findById(courseId);
        if (course.isPresent()) {
            return course.get();
        }
        return null;
    }

    public CousreEntity saveCourse(CousreEntity courseEntity) {
        CousreEntity course = courseRepository.save(courseEntity);
        return course;
    }

    public void deleteCourseById(Integer courseId) {
        courseRepository.deleteById(courseId);
    }
}

