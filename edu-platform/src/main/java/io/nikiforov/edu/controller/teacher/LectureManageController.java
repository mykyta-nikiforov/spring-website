package io.nikiforov.edu.controller.teacher;

import io.nikiforov.edu.dao.LectureFileRepository;
import io.nikiforov.edu.entity.*;
import io.nikiforov.edu.model.*;
import io.nikiforov.edu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @Autowired
    private LectureFileRepository lectureFileRepository;

    @Autowired
    private LecturePDFFileService lecturePDFFileService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/add-lecture")
    public Lecture addLecture(@RequestBody LectureInfo lectureInfo) {
        return lectureService.addLecture(lectureInfo);
    }

    // TODO check of courseId and id
    @GetMapping("/courses-manage/{courseId}/edit-lecture/{id}")
    public String editCoursePage(@PathVariable("courseId") int courseId,
                                 @PathVariable("id") int id, Model model) {
        model.addAttribute("lecture", lectureService.getLecture(id));
        model.addAttribute("lectureFileInfo", new LectureFileInfo()); // TODO maybe delete
        model.addAttribute("lectureFiles", lectureFileService.findAllByLectureId(id));
        model.addAttribute("pdfFiles",
                lectureFileRepository.findAllByLectureIdAndContentType(id, "application/pdf")); // TODO replace to service
        model.addAttribute("lecturePdfFile", lecturePDFFileService.findOne(id));
        return "teacher/lectureEdit";
    }

    @ResponseBody
    @RequestMapping(value = "/update-lecture", method = RequestMethod.PUT)
    public Lecture updateLecture(@RequestBody LectureInfo lectureInfo) {
        return lectureService.updateLecture(lectureInfo);
    }

    @ResponseBody
    @RequestMapping(value = "/delete-lecture/{id}", method = RequestMethod.DELETE)
    public String deleteLecture(@PathVariable("id") int id) {
        // Get course of this lecture
        lectureService.deleteLecture(id);
        return "deleted";
    }

    @ResponseBody
    @RequestMapping(value = "/add-lecture-file", method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public LectureFile uploadLectureFile(@RequestPart("lectureFileInfo")
                                                 LectureFileInfo lectureFileInfo,
                                         @RequestPart("file") MultipartFile file)
            throws IOException {
        return lectureFileService.save(lectureFileInfo, file);
    }

    @GetMapping("/displayLecture")
    public void showImage(@RequestParam("id") int lectureId, HttpServletResponse response)
            throws IOException {
        LectureFile lectureFile = lectureFileService.findById(lectureId);
        byte[] lectureFileData = lectureFile.getData();
        response.setContentType(lectureFile.getContentType());
        response.getOutputStream().write(lectureFileData);
        response.setContentLength(lectureFileData.length);
        response.getOutputStream().close();
    }

    @ResponseBody
    @RequestMapping(value = "/delete-lecture-file/{id}", method = RequestMethod.DELETE)
    public boolean deleteLectureFile(@PathVariable("id") int id) {
        lectureFileService.delete(id);
        return true;
    }

    @ResponseBody
    @RequestMapping(value = "/add-lecture-pdf", method = RequestMethod.POST)
    public LecturePDFFile addLecturePDF(@RequestBody LecturePDFFileInfo lecturePDFFileInfo) {
        return lecturePDFFileService.save(lecturePDFFileInfo);
    }
}
