package io.nikiforov.edu.controller.course;

import io.nikiforov.edu.entity.Course;
import io.nikiforov.edu.entity.Lecture;
import io.nikiforov.edu.entity.LectureFile;
import io.nikiforov.edu.model.LectureFileInfo;
import io.nikiforov.edu.model.LectureInfo;
import io.nikiforov.edu.service.CourseService;
import io.nikiforov.edu.service.LectureFileService;
import io.nikiforov.edu.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class LectureManageController {

    @Autowired
    LectureFileService lectureFileService;

    @Autowired
    private LectureService lectureService;

    @Autowired
    private CourseService courseService;

    @PostMapping("/add-lecture")
    public String addLecture(@ModelAttribute("newLecture") LectureInfo lectureInfo) {
        lectureService.saveLectureFromModel(lectureInfo);
        return "redirect:/courses-manage/" + lectureInfo.getCourseId();
    }

    @GetMapping("/edit-lecture/{id}")
    public String editCoursePage(@PathVariable int id, Model model) {
        model.addAttribute("lecture", lectureService.getLecture(id));
        model.addAttribute("lectureFileInfo", new LectureFileInfo());
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

    @PostMapping("/uploadLectureFile")
    public String uploadLectureFile(@RequestParam("file") MultipartFile file,
                                    @ModelAttribute("lectureFileInfo") LectureFileInfo
                                            lectureFileInfo) throws IOException {

        int id = lectureFileInfo.getLectureId();
        Lecture lecture = lectureService.getLecture(id);
        LectureFile lectureFile = new LectureFile();
        lectureFile.setLecture(lecture);
        lectureFile.setFileName(lectureFileInfo.getName());
        lectureFile.setData(file.getBytes());
        System.out.println(lectureFile);
        lectureFileService.save(lectureFile);
        return "redirect:/edit-lecture/" + id;
    }
}
