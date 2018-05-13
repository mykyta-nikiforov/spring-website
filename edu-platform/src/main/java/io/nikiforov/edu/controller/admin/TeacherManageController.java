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

    @ResponseBody
    @RequestMapping(value = "/admin/update-teacher", method = RequestMethod.PUT)
    public Teacher updateTeacher(@RequestBody TeacherInfo teacherInfo) {
        return teacherService.saveWithoutPassword(teacherInfo);
    }

    @ResponseBody
    @PostMapping("/admin/update-teacher-password")
    public String updateTeacherPassword(@RequestBody TeacherInfo teacherInfo) {
        teacherService.savePassword(teacherInfo);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/admin/delete-teacher", method = RequestMethod.DELETE)
    public String deleteTeacher(@RequestParam("id") int id) {
        teacherService.delete(id);
        return "deleted";
    }
}