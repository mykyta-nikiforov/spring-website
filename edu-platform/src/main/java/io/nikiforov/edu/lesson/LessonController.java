package io.nikiforov.edu.lesson;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.nikiforov.edu.course.Course;

@RestController
public class LessonController {
	
	@Autowired
	private LessonService lessonService;
	
	@GetMapping("/courses/{id}/lessons")
	public List<Lesson> getAllLessons(@PathVariable int id){
		return lessonService.getAllLessons(id);
	}
	
	@GetMapping("/courses/{courseId}/lessons/{id}")
	public Lesson getLesson(@PathVariable int id) {
		return lessonService.getLesson(id);
	}
	
	@PostMapping("/courses/{courseId}/lessons")
	public void addLesson(@RequestBody Lesson lesson, @PathVariable int courseId) {
		lesson.setCourse(new Course(courseId, "", ""));
		lessonService.addLesson(lesson);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/courses/{courseId}/lessons/{id}")
	public void updateLesson(@RequestBody Lesson lesson, @PathVariable int courseId,
							@PathVariable int id) {
		lesson.setCourse(new Course(courseId, "", ""));
		lessonService.updateLesson(lesson);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/courses/{courseId}/lessons/{id}")
	public void deleteCourse(@PathVariable int id) {
		lessonService.deleteLesson(id);
	}
	
}
