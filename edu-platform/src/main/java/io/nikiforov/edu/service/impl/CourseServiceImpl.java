package io.nikiforov.edu.service.impl;

import io.nikiforov.edu.dao.CourseRepository;
import io.nikiforov.edu.entity.Course;
import io.nikiforov.edu.model.CourseInfo;
import io.nikiforov.edu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService{

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

    @Override
    public Course addCourse(CourseInfo courseInfo) {
        return courseRepository.save(new Course(courseInfo));
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public Course updateCourse(CourseInfo courseInfo) {
        Course result = getCourse(courseInfo.getId());
        result.setName(courseInfo.getName());
        result.setDescription(courseInfo.getDescription());
        return courseRepository.save(result);
    }

    public void deleteCourse(int id) {
        courseRepository.delete(id);
    }

    @Override
    public Course getCourseByLectureId(int id) {
        return courseRepository.findCourseByLectureId(id);
    }

    @Override
    public Course getCourseByLabWorkId(int id) {
        return courseRepository.findCourseByLabWorkId(id);
    }
}
