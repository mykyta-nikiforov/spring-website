package io.nikiforov.edu.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TeacherController {

    @PreAuthorize("hasAnyRole('TEACHER')")
    @ResponseBody
    @GetMapping("/pageForTeachers")
    public String teacherPage() {
        return "Only Teacher can see this";
    }
}
