package io.nikiforov.edu.course;

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

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/courses")
	public List<Course> getCources(){
		return courseService.getAllCourses();
	}
	
	@GetMapping("/courses/{id}")
	public Course getCourse(@PathVariable int id) {
		return courseService.getCourse(id);
	}
	
	@PostMapping("/courses")
	public void addCourse(@RequestBody Course course) {
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable int id) {
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/courses/{id}")
	public void deleteCourse(@PathVariable int id) {
		courseService.deleteCourse(id);
	}
	
}
