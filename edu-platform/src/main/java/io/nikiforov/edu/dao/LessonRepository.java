package io.nikiforov.edu.dao;

import java.util.List;

import io.nikiforov.edu.entity.Lesson;
import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson, Integer>{
	
	List<Lesson> findByCourseId(int courseId);
}
