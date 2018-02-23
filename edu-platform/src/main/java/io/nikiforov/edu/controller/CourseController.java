package io.nikiforov.edu.controller;

import java.util.List;

import io.nikiforov.edu.entity.Course;
import io.nikiforov.edu.entity.Lecture;
import io.nikiforov.edu.model.LectureInfo;
import io.nikiforov.edu.service.CourseService;
import io.nikiforov.edu.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/all-courses")
    public String mainPage(HttpServletRequest request) {
        request.setAttribute("courses", courseService.getAllCourses());
        return "coursesPage";
    }

    @GetMapping("/course-manage")
    public String coursesManage(Model model){
        model.addAttribute("allcourses", courseService.getAllCourses());
        model.addAttribute("course", new Course());
        return "coursesManage";
    }

    @PostMapping("/add-course")
    public String addNewCourse(@ModelAttribute("course") Course course){
        courseService.addCourse(course);
        return "redirect:/course-manage";
    }

    @GetMapping("/delete-course")
    public String deleteCourseById(@RequestParam int id){
        courseService.deleteCourse(id);
        return "redirect:/course-manage";
    }

    @GetMapping("/edit-course/{id}")
    public String editCoursePage(@PathVariable int id, Model model){
        model.addAttribute("course", courseService.getCourse(id));
        model.addAttribute("lectures", lectureService.getAllLectures(id));
        LectureInfo lectureInfo = new LectureInfo();
        lectureInfo.setCourseId(id);
        model.addAttribute("newLecture", lectureInfo);
        return "courseEdit";
    }

    @PostMapping("/update-course")
    public String updateCourse(@ModelAttribute("course") Course course){
        courseService.updateCourse(course);
        return "redirect:/edit-course/" + course.getId();
    }

    @GetMapping("/course-{id}")
    public String coursePage(@PathVariable int id, Model model){
        model.addAttribute("course", courseService.getCourse(id));
        model.addAttribute("lectures", lectureService.getAllLectures(id));
        return "coursePage";
    }

}