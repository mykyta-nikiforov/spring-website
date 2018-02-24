package io.nikiforov.edu.dao;

import io.nikiforov.edu.entity.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends CrudRepository<Course, Integer>{

    @Query("select c from Course c left join c.lectures l where " +
            "l.id = :lecture_id")
    Course findCourseByLectureId(@Param("lecture_id") int id);
}
