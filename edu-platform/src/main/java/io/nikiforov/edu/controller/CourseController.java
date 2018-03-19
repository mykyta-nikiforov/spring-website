package io.nikiforov.edu.controller;

import java.util.List;

import io.nikiforov.edu.entity.Course;
import io.nikiforov.edu.entity.Lecture;
import io.nikiforov.edu.model.LabWorkInfo;
import io.nikiforov.edu.model.LectureInfo;
import io.nikiforov.edu.service.CourseService;
import io.nikiforov.edu.service.LabWorkService;
import io.nikiforov.edu.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private LectureService lectureService;

    @Autowired
    private LabWorkService labWorkService;

//    @GetMapping("/courses")
//    @ResponseBody
//    public List<Course> getCources(){
//        return courseService.getAllCourses();
//    }
//
//    @GetMapping("/courses/{id}")
//    @ResponseBody
//    public Course getCourse(@PathVariable int id) {
//        return courseService.getCourse(id);
//    }
//
//    @PostMapping("/courses")
//    @ResponseBody
//    public void addCourse(@RequestBody Course course) {
//        courseService.addCourse(course);
//    }
//
//    @RequestMapping(method=RequestMethod.PUT, value="/courses/{id}")
//    @ResponseBody
//    public void updateCourse(@RequestBody Course course, @PathVariable int id) {
//        courseService.updateCourse(course);
//    }
//
//    @RequestMapping(method=RequestMethod.DELETE, value="/courses/{id}")
//    @ResponseBody
//    public void deleteCourse(@PathVariable int id) {
//        courseService.deleteCourse(id);
//    }

    @RequestMapping("/all-courses")
    public String mainPage(HttpServletRequest request) {
        request.setAttribute("courses", courseService.getAllCourses());
        return "student/coursesPage";
    }

    @GetMapping("/course-{id}")
    public String coursePage(@PathVariable int id, Model model){
        model.addAttribute("course", courseService.getCourse(id));
        model.addAttribute("lectures", lectureService.getAllLectures(id));
        return "student/coursePage";
    }
}