package io.nikiforov.edu.dao;

import java.util.List;

import io.nikiforov.edu.entity.Lecture;
import org.springframework.data.repository.CrudRepository;

public interface LectureRepository extends CrudRepository<Lecture, Integer>{
	
	List<Lecture> findByCourseId(int courseId);
}
