package io.nikiforov.edu.controller;

import io.nikiforov.edu.entity.LectureFile;
import io.nikiforov.edu.entity.LecturePDFFile;
import io.nikiforov.edu.service.LectureFileService;
import io.nikiforov.edu.service.LecturePDFFileService;
import io.nikiforov.edu.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LectureController {

    @Autowired
    private LectureService lectureService;

    @Autowired
    private LecturePDFFileService lecturePDFFileService;

    @Autowired
    private LectureFileService lectureFileService;

    //TODO make smthn with {course-id}
    @GetMapping("/course-{course-id}/{lecture-id}")
    public String lecturePage(@PathVariable("course-id") int courseId,
                              @PathVariable("lecture-id") int lectureId,
                              Model model) {
        model.addAttribute("lecture", lectureService.getLecture(lectureId));
        model.addAttribute("lectureFiles", lectureFileService.findAllByLectureId(lectureId));
        return "student/lecturePage";
    }

    @GetMapping(value = "/displayPDF", produces = "application/pdf")
    @ResponseBody
    public byte[] displayPDF(@RequestParam("id") int lectureId)
            throws IOException {
        LecturePDFFile lecturePDFFile = lecturePDFFileService.findOne(lectureId);
        LectureFile lectureFile = lecturePDFFile.getLectureFile();
        return lectureFile.getData();
    }

    @GetMapping("/lecture-file")
    public void showImage(@RequestParam("id") int lectureId, HttpServletResponse response)
            throws IOException {
        LectureFile lectureFile = lectureFileService.findById(lectureId);
        byte[] lectureFileData = lectureFile.getData();
        response.setContentType(lectureFile.getContentType());
        response.getOutputStream().write(lectureFileData);
        response.setContentLength(lectureFileData.length);
        response.getOutputStream().close();
    }
}