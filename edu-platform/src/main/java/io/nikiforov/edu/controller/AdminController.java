package io.nikiforov.edu.controller;

import io.nikiforov.edu.entity.*;
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

    @GetMapping("/admin/users-manage/students")
    public String studentManage(Model model) {
        model.addAttribute("student", studentService.findAll());
        model.addAttribute("newStudent", new Student());
        return "usersManageStudents";
    }

    @PostMapping("/admin/add-student")
    public String addUser(@ModelAttribute("newStudent") Student modelStudent) {
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleService.getRole("STUDENT"));
        Student result = new Student(modelStudent.getEmail(),
                passwordEncoder.encode(modelStudent.getPassword()), roleSet);
        result.setName(modelStudent.getName());
        studentService.save(result);
        return "redirect:/admin/users-manage";
    }

    @GetMapping("/admin/users-manage/teachers")
    public String teachersManagePage(Model model) {
        model.addAttribute("newTeacher", new Teacher());
        model.addAttribute("degrees", degreeService.findAll());
        System.out.println(teacherService.findAll());
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
        result.setDegree(modelTeacher.getDegree());
        result.setSurname(modelTeacher.getSurname());
        teacherService.save(result);
        return "redirect:/admin/users-manage/teachers";
    }

    @GetMapping("/admin/group-manage")
    public String groupsManagePage(Model model) {
        model.addAttribute("newGroup", new Group());
        model.addAttribute("groups", groupService.findAll());
        model.addAttribute("teachers", teacherService.findAll());
        return "groupsManage";
    }

    @PostMapping("/admin/add-group")
    public String addGroup(@ModelAttribute("newGroup") Group modelGroup) {
        System.out.println(modelGroup);
        groupService.save(modelGroup);
        return "redirect:/admin/group-manage";
    }
}