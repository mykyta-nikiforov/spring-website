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


    @GetMapping("/courses-manage/{courseId}/edit-lecture/{id}")
    public String editCoursePage(@PathVariable("courseId") int courseId,
                                 @PathVariable("id") int id, Model model) {
        model.addAttribute("lecture", lectureService.getLecture(id));
        model.addAttribute("lectureFileInfo", new LectureFileInfo());
        model.addAttribute("lectureFiles", lectureFileService.findAllByLectureId(id));
        return "teacher/lectureEdit";
    }

    @ResponseBody
    @RequestMapping(value = "/update-lecture", method = RequestMethod.PUT)
    public Lecture updateLecture(@RequestBody LectureInfo lectureInfo) {
        return lectureService.updateLecture(lectureInfo);
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

//    @PostMapping("/uploadLectureFile")
//    public String uploadLectureFile(@RequestParam("file") MultipartFile file,
//                                    @ModelAttribute("lectureFileInfo") LectureFileInfo
//                                            lectureFileInfo) throws IOException {
//
//        int id = lectureFileInfo.getLectureId();
//        lectureFileService.save(lectureFileInfo, file, id);
//        return "redirect:/courses-manage/{TODO}/edit-lecture/" + id;
//    }

    @ResponseBody
    @RequestMapping(value = "/add-lecture-file", method = RequestMethod.POST,
                    consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public LectureFile uploadLectureFile(@RequestPart("lectureFileInfo")
                                                                   LectureFileInfo lectureFileInfo,
                                                       @RequestPart("file") MultipartFile file)
                                                       throws IOException {
        System.out.println("Hi from controller");
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
        return "redirect:/courses-manage/TODO/edit-lecture/" + lectureId;
    }

}
