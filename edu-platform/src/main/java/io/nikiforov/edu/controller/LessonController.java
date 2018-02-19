package io.nikiforov.edu.controller;

import java.util.List;

import io.nikiforov.edu.entity.Lesson;
import io.nikiforov.edu.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.nikiforov.edu.entity.Course;

@RestController
public class LessonController {
    
    @Autowired
    private LessonService lessonService;
    
    @GetMapping("/courses/{id}/lessons")
    @ResponseBody
    public List<Lesson> getAllLessons(@PathVariable int id){
        return lessonService.getAllLessons(id);
    }
    
    @GetMapping("/courses/{courseId}/lessons/{id}")
    @ResponseBody
    public Lesson getLesson(@PathVariable int id) {
        return lessonService.getLesson(id);
    }
    
    @PostMapping("/courses/{courseId}/lessons")
    @ResponseBody
    public void addLesson(@RequestBody Lesson lesson, @PathVariable int courseId) {
        lesson.setCourse(new Course(courseId, "", ""));
        lessonService.addLesson(lesson);
    }
    
    @RequestMapping(method=RequestMethod.PUT, value="/courses/{courseId}/lessons/{id}")
    public void updateLesson(@RequestBody Lesson lesson, @PathVariable int courseId,
                            @PathVariable int id) {
        lesson.setCourse(new Course(courseId, "", ""));
        lessonService.updateLesson(lesson);
    }
    
    @RequestMapping(method=RequestMethod.DELETE, value="/courses/{courseId}/lessons/{id}")
    public void deleteCourse(@PathVariable int id) {
        lessonService.deleteLesson(id);
    }
    
}
