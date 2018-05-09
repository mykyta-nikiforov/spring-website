package io.nikiforov.edu.controller;

import io.nikiforov.edu.entity.LectureFile;
import io.nikiforov.edu.entity.LecturePDFFile;
import io.nikiforov.edu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class LectureController {

    @Autowired
    private LectureService lectureService;

    @Autowired
    private LecturePDFFileService lecturePDFFileService;

    @Autowired
    private LectureFileService lectureFileService;

    @Autowired
    private LabWorkService labWorkService;

    @Autowired
    private LabWorkFileService labWorkFileService;

    //TODO make smthn with {course-id}
    @GetMapping("/course-{course-id}/lec-{lecture-id}")
    public String lecturePage(@PathVariable("course-id") int courseId,
                              @PathVariable("lecture-id") int lectureId,
                              Model model) {
        model.addAttribute("lecture", lectureService.getLecture(lectureId));
        model.addAttribute("lectureFiles", lectureFileService.findAllByLectureId(lectureId));
        return "student/lecturePage";
    }

    @GetMapping("/course-{course-id}/lab-{labWork-id}")
    public String labWorkPage(@PathVariable("course-id") int courseId,
                              @PathVariable("labWork-id") int labWorkId,
                              Model model) {
        model.addAttribute("labWork", labWorkService.getLabWork(labWorkId));
        model.addAttribute("labWorkFiles", labWorkFileService.findAllByLabWorkId(labWorkId));
        return "student/labworkPage";
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
    public HttpEntity<byte[]> downloadLectureFile(@RequestParam("id") int lectureId) throws UnsupportedEncodingException {
        LectureFile lectureFile = lectureFileService.findById(lectureId);
        String fileName = URLEncoder.encode(lectureFile.getFileName(), "UTF-8");

        byte[] lectureFileData = lectureFile.getData();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", lectureFile.getContentType());
        responseHeaders.add("Content-Disposition",
                "attachment; filename*=UTF-8''" + fileName);
        return new HttpEntity<>(lectureFileData, responseHeaders);
    }
}