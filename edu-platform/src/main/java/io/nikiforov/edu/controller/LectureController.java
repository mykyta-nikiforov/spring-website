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

    //TODO make smthn with {course-id}
    @GetMapping("/course-{course-id}/{lecture-id}")
    public String lecturePage(@PathVariable("course-id") int courseId,
                              @PathVariable("lecture-id") int lectureId,
                              Model model) {
        model.addAttribute("lecture", lectureService.getLecture(lectureId));
        return "student/lecturePage";
    }
}