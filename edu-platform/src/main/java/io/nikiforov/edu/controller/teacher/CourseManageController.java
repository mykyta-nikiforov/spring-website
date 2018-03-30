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

    @ResponseBody
    @PostMapping("/add-course")
    public Course addCourseREST(@RequestBody CourseInfo courseInfo) {
        return courseService.addCourse(courseInfo);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete-course")
    public String deleteCourseById(@RequestParam int id){
        courseService.deleteCourse(id);
        return "Hello again!";
    }

    @GetMapping("/courses-manage/{id}")
    public String editCoursePage(@PathVariable int id, Model model){
        model.addAttribute("course", courseService.getCourse(id));
        model.addAttribute("lectures", lectureService.getAllLectures(id));
        model.addAttribute("labWorks", labWorkService.findAllByCourseId(id));
        return "teacher/courseEdit";
    }

    @ResponseBody
    @RequestMapping(value = "/update-course", method = RequestMethod.PUT)
    public Course updateCourse(@RequestBody CourseInfo courseInfo){
        return courseService.updateCourse(courseInfo);
    }
}
