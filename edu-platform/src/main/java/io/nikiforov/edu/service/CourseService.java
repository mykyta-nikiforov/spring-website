package io.nikiforov.edu.service;

import java.util.ArrayList;
import java.util.List;

import io.nikiforov.edu.entity.Course;
import io.nikiforov.edu.dao.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    
    @Autowired
    private CourseRepository courseRepository;
    
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll()
                .forEach(courses::add);
        return courses;
    }
    
    public Course getCourse(int id) {
        return courseRepository.findOne(id);
    }
    
    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(int id) {
        courseRepository.delete(id);
    }
}
