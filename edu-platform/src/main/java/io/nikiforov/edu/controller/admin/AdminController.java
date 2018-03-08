package io.nikiforov.edu.controller.admin;

import io.nikiforov.edu.entity.*;
import io.nikiforov.edu.model.TeacherInfo;
import io.nikiforov.edu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentService studentService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private GroupService groupService;

    @Autowired
    private DegreeService degreeService;

    @GetMapping("/admin")
    public String adminPage() {
        return "adminPage";
    }

    @GetMapping("/admin/users-manage")
    public String usersManage() {
        return "usersManage";
    }

    @GetMapping("/admin/users-manage/teachers")
    public String teachersManagePage(Model model) {
        model.addAttribute("newTeacher", new TeacherInfo());
        model.addAttribute("degrees", degreeService.findAll());
        model.addAttribute("teachers", teacherService.findAll());
        return "usersManageTeachers";
    }

    @PostMapping("/admin/add-teacher")
    public String addTeacher(@ModelAttribute("newTeacher") TeacherInfo teacherInfo) {
        // Create Teacher from TeacherInfo
        Teacher result = new Teacher(teacherInfo);
        // Create roleSet and set it
        Set<Role> rolesSet = new HashSet<>();
        rolesSet.add(roleService.getRole("TEACHER"));
        result.setRoles(rolesSet);
        // Encode password
        result.setPassword(passwordEncoder.encode(result.getPassword()));
        teacherService.save(result);
        return "redirect:/admin/users-manage/teachers";
    }
}