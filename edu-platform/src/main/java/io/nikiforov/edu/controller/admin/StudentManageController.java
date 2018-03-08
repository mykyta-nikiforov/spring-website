package io.nikiforov.edu.controller.admin;

import io.nikiforov.edu.entity.Role;
import io.nikiforov.edu.entity.Student;
import io.nikiforov.edu.service.GroupService;
import io.nikiforov.edu.service.RoleService;
import io.nikiforov.edu.service.StudentService;
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
public class StudentManageController {

    @Autowired
    StudentService studentService;

    @Autowired
    GroupService groupService;

    @Autowired
    RoleService roleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/admin/users-manage/students")
    public String studentManage(Model model) {
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("groups", groupService.findAll());
        model.addAttribute("newStudent", new Student());
        return "usersManageStudents";
    }

    @PostMapping("/admin/add-student")
    public String addUser(@ModelAttribute("newStudent") Student modelStudent) {
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleService.getRole("STUDENT"));
        // Encode password
        modelStudent.setPassword(passwordEncoder.encode(modelStudent.getPassword()));
        Student result = new Student(modelStudent);
        studentService.save(result);
        return "redirect:/admin/users-manage";
    }
}
