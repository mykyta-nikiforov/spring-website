package io.nikiforov.edu.controller.admin;

import io.nikiforov.edu.entity.Role;
import io.nikiforov.edu.entity.Student;
import io.nikiforov.edu.model.StudentInfo;
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
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/admin/users-manage/students/add-student")
    public String addUser(@ModelAttribute("newStudent") StudentInfo studentInfo) {
        // Create Student from StudentInfo
        Student result = new Student(studentInfo);
        // Create roleSet and set it
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleService.getRole("STUDENT"));
        result.setRoles(roleSet);
        // Encode password
        result.setPassword(passwordEncoder.encode(result.getPassword()));
        studentService.save(result);
        return "redirect:/admin/users-manage/students";
    }

    @GetMapping("/admin/users-manage/students/delete-student")
    public String deleteStudent(@RequestParam("id") int id) {
        studentService.delete(id);
        return "redirect:/admin/users-manage/students";
    }
}