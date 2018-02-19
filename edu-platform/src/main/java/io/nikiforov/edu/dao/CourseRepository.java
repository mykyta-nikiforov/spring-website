package io.nikiforov.edu.dao;

import io.nikiforov.edu.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer>{
	
}
