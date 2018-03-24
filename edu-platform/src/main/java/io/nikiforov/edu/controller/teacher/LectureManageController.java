package io.nikiforov.edu.controller.teacher;

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

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LectureManageController {

    @Autowired
    LectureFileService lectureFileService;

    @Autowired
    private LectureService lectureService;

    @Autowired
    private CourseService courseService;

//    @PostMapping("/add-lecture")
//    public String addLecture(@ModelAttribute("newLecture") LectureInfo lectureInfo) {
//        lectureService.saveLectureFromModel(lectureInfo);
//        return "redirect:/courses-manage/" + lectureInfo.getCourseId();
//    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/add-lecture")
    public Lecture addLecture(@RequestBody LectureInfo lectureInfo) {
//        lectureInfo.setCourseId(course_id);
        System.out.println(lectureInfo);

        Lecture newLecture = lectureService.addLecture(lectureInfo);
        System.out.println("From Controller: " + newLecture);
        return newLecture;
    }


    @GetMapping("/edit-lecture/{id}")
    public String editCoursePage(@PathVariable int id, Model model) {
        model.addAttribute("lecture", lectureService.getLecture(id));
        model.addAttribute("lectureFileInfo", new LectureFileInfo());
        model.addAttribute("lectureFiles", lectureFileService.findAllByLectureId(id));
        return "teacher/lectureEdit";
    }

    @PostMapping("/update-lecture")
    public String updateLecture(@ModelAttribute("lecture") Lecture lecture) {
        /* Lecture from model doesn't have course. Firstly, we find course,
         * set it to lecture, and only then update the lecture. */
        Course course = courseService.getCourseByLectureId(lecture.getId());
        lecture.setCourse(course);
        lectureService.updateLecture(lecture);
        return "redirect:/courses-manage/" + course.getId();
    }

//    @GetMapping("/delete-lecture")
//    public String deleteLecture(@RequestParam("id") int id) {
//        // Get course of this lecture
//        Course course = courseService.getCourseByLectureId(id);
//        lectureService.deleteLecture(id);
//        return "redirect:/courses-manage/" + course.getId();
//    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete-lecture/{id}")
    public String deleteLecture(@PathVariable("id") int id) {
        // Get course of this lecture
        lectureService.deleteLecture(id);
        return "deleted";
    }

    @PostMapping("/uploadLectureFile")
    public String uploadLectureFile(@RequestParam("file") MultipartFile file,
                                    @ModelAttribute("lectureFileInfo") LectureFileInfo
                                            lectureFileInfo) throws IOException {

        int id = lectureFileInfo.getLectureId();
        lectureFileService.save(lectureFileInfo, file, id);
        return "redirect:/edit-lecture/" + id;
    }

    @GetMapping("/displayLecture")
    public void showImage(@RequestParam("id") int lectureId, HttpServletResponse response)
            throws IOException {
        LectureFile lectureFile = lectureFileService.findById(lectureId);
        byte[] lectureFileData = lectureFile.getData();
        response.setContentType(lectureFile.getContentType());
        response.getOutputStream().write(lectureFileData);
        response.setContentLength(lectureFileData.length);
//        response.set
        response.getOutputStream().close();
    }
//
//    @GetMapping(value = "/displayLecture", produces="application/pdf")
//    @ResponseBody
//    public byte[] showImage(@RequestParam("id") int lectureId)
//            throws IOException {
//        LectureFile lectureFile = lectureFileService.findById(lectureId);
//        return lectureFile.getData();
//    }

    @GetMapping("/deleteLectureFile")
    public String deleteLectureFile(@RequestParam("id") int lectureFileId) {
        int lectureId = lectureFileService.findById(lectureFileId).getLecture().getId();
        lectureFileService.delete(lectureFileId);
        return "redirect:/edit-lecture/" + lectureId;
    }

}
