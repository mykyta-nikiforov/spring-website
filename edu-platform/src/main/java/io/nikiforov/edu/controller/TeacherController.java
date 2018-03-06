package io.nikiforov.edu.controller;

import io.nikiforov.edu.entity.Teacher;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TeacherController {

    @PreAuthorize("hasAnyRole('TEACHER')")
    @ResponseBody
    @GetMapping("/pageForTeachers")
    public String teacherPage(@AuthenticationPrincipal UserDetails userDetails) {
        System.out.println(userDetails.getClass());
        Teacher teacher = (Teacher) userDetails;
        return "Only Teacher can see this asdasd" + teacher.getName();
    }
}
