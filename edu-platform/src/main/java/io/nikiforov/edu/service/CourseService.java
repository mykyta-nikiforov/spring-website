package io.nikiforov.edu.service;

import java.util.List;
import io.nikiforov.edu.entity.Course;
import io.nikiforov.edu.model.CourseInfo;

public interface CourseService {

    List<Course> getAllCourses();
    Course getCourse(int id);
    void addCourse(Course course);

    Course addCourse(CourseInfo courseInfo);
    void updateCourse(Course course);
    void deleteCourse(int id);

    Course getCourseByLectureId(int id);

    Course getCourseByLabWorkId(int id);

}
