package io.nikiforov.edu.controller;

import io.nikiforov.edu.entity.Lecture;
import io.nikiforov.edu.model.LectureInfo;
import io.nikiforov.edu.service.CourseService;
import io.nikiforov.edu.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import io.nikiforov.edu.entity.Course;

@Controller
public class LectureController {

    @Autowired
    private LectureService lectureService;

    @Autowired
    private CourseService courseService;

    @PostMapping("/add-lecture")
    public String addLecture(@ModelAttribute("newLecture") LectureInfo lectureInfo) {
        System.out.println(lectureInfo);
        lectureService.saveLectureFromModel(lectureInfo);
        return "redirect:/courses-manage/" + lectureInfo.getCourseId();
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
        System.out.println(lectureService.getLecture(id).toString());
        return "lectureEdit";
    }

    @PostMapping("/update-lecture")
    public String updateLecture(@ModelAttribute("lecture") Lecture lecture){
        /* Lecture from model doesn't have course. Firstly, we find course,
         * set it to lecture, and only then update the lecture. */
        Course course = courseService.getCourseByLectureId(lecture.getId());
        lecture.setCourse(course);
        lectureService.updateLecture(lecture);
        return "redirect:/courses-manage/" + course.getId();
    }

    @GetMapping("/delete-lecture")
    public String deleteLecture(@RequestParam("id") int id) {
        // Get course of this lecture
        Course course = courseService.getCourseByLectureId(id);
        lectureService.deleteLecture(id);
        return "redirect:/courses-manage/" + course.getId();
    }
}