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

//    @PostMapping("/add-course")
//    public String addNewCourse(@ModelAttribute("course") Course course){
//        courseService.addCourse(course);
//        return "redirect:/courses-manage";
//    }

    @ResponseBody
    @PostMapping("/add-course")
    public Course addCourseREST(@RequestBody CourseInfo courseInfo) {
        Course course = courseService.addCourse(courseInfo);
        return course;
    }

//    @GetMapping("/delete-course")
//    public String deleteCourseById(@RequestParam int id){
//        courseService.deleteCourse(id);
//        return "redirect:/courses-manage";
//    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete-course")
    public void deleteCourseById(@RequestParam int id){
        System.out.println(id);
        courseService.deleteCourse(id);
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
}
