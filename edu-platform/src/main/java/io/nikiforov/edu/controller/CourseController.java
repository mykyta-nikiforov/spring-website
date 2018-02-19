package io.nikiforov.edu.controller;

import java.util.List;

import io.nikiforov.edu.entity.Course;
import io.nikiforov.edu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CourseController {
	
	@Autowired
	private CourseService courseService;

	@GetMapping("/courses")
    @ResponseBody
	public List<Course> getCources(){
		return courseService.getAllCourses();
	}
	
	@GetMapping("/courses/{id}")
    @ResponseBody
	public Course getCourse(@PathVariable int id) {
		return courseService.getCourse(id);
	}
	
	@PostMapping("/courses")
    @ResponseBody
	public void addCourse(@RequestBody Course course) {
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/courses/{id}")
    @ResponseBody
	public void updateCourse(@RequestBody Course course, @PathVariable int id) {
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/courses/{id}")
    @ResponseBody
	public void deleteCourse(@PathVariable int id) {
		courseService.deleteCourse(id);
	}

    @RequestMapping("/allCourses")
    public String mainPage(HttpServletRequest request) {
        request.setAttribute("courses", courseService.getAllCourses());
        return "allCourses";
    }

	@GetMapping("/courseManage")
    public String courseManage(Model model){
        model.addAttribute("course", new Course());
	    return "courseManage";
    }

    @PostMapping("/addCourse")
    public String addNewCourse(@ModelAttribute("course") Course course){
        courseService.addCourse(new Course(course));
        return "courseManage";
    }


}
