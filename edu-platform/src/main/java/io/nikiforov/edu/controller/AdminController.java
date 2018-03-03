package io.nikiforov.edu.controller;

import io.nikiforov.edu.entity.Role;
import io.nikiforov.edu.entity.Student;
import io.nikiforov.edu.entity.Teacher;
import io.nikiforov.edu.entity.User;
import io.nikiforov.edu.service.RoleService;
import io.nikiforov.edu.service.StudentService;
import io.nikiforov.edu.service.TeacherService;
import io.nikiforov.edu.service.UserService;
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

    @GetMapping("/admin/users-manage")
    public String manageUsersPage(Model model){
        model.addAttribute("student", studentService.findAll());
        model.addAttribute("newStudent", new Student());
        return "usersManage";
    }

    @PostMapping("/admin/add-student")
    public String addUser(@ModelAttribute("newStudent") Student modelStudent){
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleService.getRole("STUDENT"));
        Student result = new Student(modelStudent.getEmail(),
                passwordEncoder.encode(modelStudent.getPassword()), roleSet);
        result.setName(modelStudent.getName());

        studentService.save(modelStudent);
        return "redirect:/admin/users-manage";
    }

    @GetMapping("/admin/users-manage/teachers")
    public String teachersManagePage(Model model) {
        model.addAttribute("newTeacher", new Teacher());
        model.addAttribute("teachers", teacherService.findAll());
//        model.
        return "usersManageTeachers";
    }

    @PostMapping("/admin/add-teacher")
    public String addTeacher(@ModelAttribute("newTeacher") Teacher modelTeacher) {
        Set<Role> rolesSet = new HashSet<>();
        rolesSet.add(roleService.getRole("TEACHER"));
        Teacher result = new Teacher(modelTeacher.getEmail(),
                passwordEncoder.encode(modelTeacher.getPassword()), rolesSet);
        result.setName(modelTeacher.getName());
        teacherService.save(result);
        return "redirect:/admin/users-manage/teachers";
    }
}