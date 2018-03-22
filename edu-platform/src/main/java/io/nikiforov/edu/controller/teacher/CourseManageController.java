package io.nikiforov.edu.controller.teacher;

import io.nikiforov.edu.entity.Course;
import io.nikiforov.edu.model.CourseInfo;
import io.nikiforov.edu.model.LabWorkInfo;
import io.nikiforov.edu.model.LectureInfo;
import io.nikiforov.edu.service.CourseService;
import io.nikiforov.edu.service.LabWorkService;
import io.nikiforov.edu.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CourseManageController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private LectureService lectureService;

    @Autowired
    private LabWorkService labWorkService;

    @GetMapping("/courses-manage")
    public String coursesManage(Model model){
        model.addAttribute("allcourses", courseService.getAllCourses());
        model.addAttribute("course", new Course());
        return "teacher/coursesManage";
    }

    @PostMapping("/add-course")
    public String addNewCourse(@ModelAttribute("course") Course course){
        courseService.addCourse(course);
        return "redirect:/courses-manage";
    }

    @GetMapping("/delete-course")
    public String deleteCourseById(@RequestParam int id){
        courseService.deleteCourse(id);
        return "redirect:/courses-manage";
    }

    @GetMapping("/courses-manage/{id}")
    public String editCoursePage(@PathVariable int id, Model model){
        model.addAttribute("course", courseService.getCourse(id));
        model.addAttribute("lectures", lectureService.getAllLectures(id));
        model.addAttribute("labWorks", labWorkService.findAllByCourseId(id));

        model.addAttribute("newLecture", LectureInfo.newInstanceWithCourseId(id));
        model.addAttribute("newLabWorkInfo", LabWorkInfo.newInstanceWithCourseId(id));
        return "teacher/courseEdit";
    }

    @PostMapping("/update-course")
    public String updateCourse(@ModelAttribute("course") Course course){
        courseService.updateCourse(course);
        return "redirect:/courses-manage/" + course.getId();
    }

    @ResponseBody
    @PostMapping("/add-course2")
    public Course addCourseREST(@RequestBody CourseInfo courseInfo) {
        System.out.println(courseInfo);
        Course course = courseService.addCourse(courseInfo);
        System.out.println(courseInfo);
        return course;
    }
}
