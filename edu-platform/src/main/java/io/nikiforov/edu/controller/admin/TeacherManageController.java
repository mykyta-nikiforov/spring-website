package io.nikiforov.edu.controller.admin;

import io.nikiforov.edu.entity.Role;
import io.nikiforov.edu.entity.Teacher;
import io.nikiforov.edu.model.TeacherInfo;
import io.nikiforov.edu.service.DegreeService;
import io.nikiforov.edu.service.RoleService;
import io.nikiforov.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.HashSet;
import java.util.Set;

@Controller
public class TeacherManageController {

    @Autowired
    DegreeService degreeService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    RoleService roleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/admin/users-manage/teachers")
    public String teachersManagePage(Model model) {
        model.addAttribute("newTeacher", new TeacherInfo());
        model.addAttribute("degrees", degreeService.findAll());
        model.addAttribute("teachers", teacherService.findAll());
        return "admin/users/usersManageTeachers";
    }

    @PostMapping("/admin/add-teacher")
    public String addTeacher(@ModelAttribute("newTeacher") TeacherInfo teacherInfo) {
        teacherService.save(teacherInfo);
        return "redirect:/admin/users-manage/teachers";
    }
}