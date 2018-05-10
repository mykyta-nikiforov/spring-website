package io.nikiforov.edu.controller.admin;

import io.nikiforov.edu.entity.Role;
import io.nikiforov.edu.entity.Student;
import io.nikiforov.edu.entity.Teacher;
import io.nikiforov.edu.model.TeacherInfo;
import io.nikiforov.edu.service.DegreeService;
import io.nikiforov.edu.service.RoleService;
import io.nikiforov.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

//    @PostMapping("/admin/add-teacher")
//    public String addTeacher(@ModelAttribute("newTeacher") TeacherInfo teacherInfo) {
//        teacherService.save(teacherInfo);
//        return "redirect:/admin/users-manage/teachers";
//    }

    @ResponseBody
    @PostMapping("/admin/add-teacher")
    public Teacher addTeacher(@RequestBody TeacherInfo teacherInfo){
        return teacherService.save(teacherInfo);
    }


    @GetMapping("/admin/users-manage/teachers/{id}")
    public String teacherPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("teacher", teacherService.getById(id));
        model.addAttribute("degrees", degreeService.findAll());
        return "admin/users/teacherProfile";
    }

    @PostMapping("/admin/users-manage/teachers/update")
    public String updateTeacher(@ModelAttribute("teacher") Teacher teacher) {
        // Set password from DB, because the parameter is absent on JSP
        teacher.setPassword(teacherService.getById(teacher.getId()).getPassword());
        teacherService.save(teacher);
        return "redirect:/admin/users-manage/teachers/" + teacher.getId();
    }

    @PostMapping("/admin/users-manage/teachers/update-password")
    public String updateTeacherPassword(@ModelAttribute("teacher") Teacher teacher) {
        String password = teacher.getPassword();
        teacher = teacherService.getById(teacher.getId());
        teacher.setPassword(passwordEncoder.encode(password));
        teacherService.save(teacher);
        return "redirect:/admin/users-manage/teachers/" + teacher.getId();
    }

    @GetMapping("/admin/users-manage/teachers/delete-teacher")
    public String deleteTeacher(@RequestParam("id") int id) {
        teacherService.delete(id);
        return "redirect:/admin/users-manage/teachers";
    }
}