package io.nikiforov.edu.lesson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
	
	@Autowired
	private LessonRepository lessonRepository;
	
	public List<Lesson> getAllLessons(int id) {
		List<Lesson> courses = new ArrayList<>();
		lessonRepository.findByCourseId(id)
				.forEach(courses::add);
		return courses;
	}
	
	public Lesson getLesson(int id) {
		return lessonRepository.findOne(id);
	}
	
	public void addLesson(Lesson lesson) {
		lessonRepository.save(lesson);
	}

	public void updateLesson(Lesson lesson) {
		lessonRepository.save(lesson);
	}

	public void deleteLesson(int id) {
		lessonRepository.delete(id);
	}
}
