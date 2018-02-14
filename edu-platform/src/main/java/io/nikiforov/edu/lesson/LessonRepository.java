package io.nikiforov.edu.lesson;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson, Integer>{
	
	List<Lesson> findByCourseId(int courseId);
}
