package io.nikiforov.edu.controller;

import io.nikiforov.edu.entity.Teacher;
import io.nikiforov.edu.model.TeacherInfo;
import io.nikiforov.edu.service.StudentService;
import io.nikiforov.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentService studentService;

    @GetMapping("/user-settings")
    public String userSettings(@AuthenticationPrincipal UserDetails userDetails) {
        GrantedAuthority role = userDetails.getAuthorities().iterator().next();
        switch (role.getAuthority()) {
            case "ROLE_TEACHER":
                return "redirect:/teacher-settings";
            case "ROLE_STUDENT":
                return "redirect:/student-settings";
            default:
                return "redirect:/";
        }
    }

    @GetMapping("/teacher-settings")
    public String teacherSettings(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        model.addAttribute("teacher", (Teacher) userDetails);
        return "user/teacherSettings";
    }

    @ResponseBody
    @PutMapping("/save-teacher-settings")
    public Teacher saveTeacherSettings(@AuthenticationPrincipal UserDetails userDetails,
                                       @RequestBody TeacherInfo teacherInfo) {
        return teacherService.save(userDetails, teacherInfo);
    }

    @ResponseBody
    @PutMapping("/save-teacher-password")
    public String saveTeacherPassword(@AuthenticationPrincipal UserDetails userDetails,
                                      @RequestBody TeacherInfo teacherInfo) {
        teacherService.savePassword(userDetails, teacherInfo);
        return "success";
    }
}