package io.nikiforov.edu.controller;

import java.util.List;

import io.nikiforov.edu.entity.Lecture;
import io.nikiforov.edu.model.LectureInfo;
import io.nikiforov.edu.service.CourseService;
import io.nikiforov.edu.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import io.nikiforov.edu.entity.Course;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LectureController {

    @Autowired
    private LectureService lectureService;

    @Autowired
    private CourseService courseService;

//    @GetMapping("/courses/{id}/lectures")
//    @ResponseBody
//    public List<Lecture> getAllLectures(@PathVariable int id){
//        return lectureService.getAllLectures(id);
//    }
//
//    @GetMapping("/courses/{courseId}/lectures/{id}")
//    @ResponseBody
//    public Lecture getLecture(@PathVariable int id) {
//        return lectureService.getLecture(id);
//    }
//
//    @PostMapping("/courses/{courseId}/lectures")
//    @ResponseBody
//    public void addLecture(@RequestBody Lecture lecture, @PathVariable int courseId) {
//        lecture.setCourse(new Course(courseId, "", ""));
//        lectureService.addLecture(lecture);
//    }
//
//    @RequestMapping(method=RequestMethod.PUT, value="/courses/{courseId}/lectures/{id}")
//    public void updateLecture(@RequestBody Lecture lecture, @PathVariable int courseId,
//                             @PathVariable int id) {
//        lecture.setCourse(new Course(courseId, "", ""));
//        lectureService.updateLecture(lecture);
//    }
//
//    @RequestMapping(method=RequestMethod.DELETE, value="/courses/{courseId}/lectures/{id}")
//    public void deleteCourse(@PathVariable int id) {
//        lectureService.deleteLecture(id);
//    }

    @PostMapping("/add-lecture")
    public String addLecture(@ModelAttribute("newLecture") LectureInfo lectureInfo) {
        System.out.println(lectureInfo);
        lectureService.saveLectureFromModel(lectureInfo);
        return "redirect:/edit-course/" + lectureInfo.getCourseId();
    }

    //TODO make smthn with {course-id}
    @GetMapping("/course-{course-id}/{lecture-id}")
    public String lecturePage(@PathVariable("course-id") int courseId,
                              @PathVariable("lecture-id") int lectureId,
                              Model model) {
        model.addAttribute("lecture", lectureService.getLecture(lectureId));
        return "lecturePage";
    }

    @GetMapping("/edit-lecture/{id}")
    public String editCoursePage(@PathVariable int id, Model model) {
        model.addAttribute("lecture", lectureService.getLecture(id));
        return "lectureEdit";
    }

    @PostMapping("/update-lecture")
    public String updateLecture(@ModelAttribute("lecture") Lecture lecture){
        lectureService.updateLecture(lecture);
        return "redirect:/course-1/" + lecture.getId();
    }

    @PostMapping("/delete-lecture")
    public String deleteLecture(@RequestParam("id") int id) {
        Course course = courseService.getCourseByLectureId(id);
        return "/edit-course/" + course.getId();
    }
}