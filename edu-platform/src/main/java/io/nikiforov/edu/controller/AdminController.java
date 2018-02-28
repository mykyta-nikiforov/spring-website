package io.nikiforov.edu.controller;

import io.nikiforov.edu.entity.Role;
import io.nikiforov.edu.entity.User;
import io.nikiforov.edu.service.RoleService;
import io.nikiforov.edu.service.UserService;
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
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/admin/users-manage")
    public String manageUsersPage(Model model){
        model.addAttribute("users", userService.findAll());
        model.addAttribute("newUser", new User());
        return "usersManage";
    }

    @PostMapping("/admin/add-user")
    public String addUser(@ModelAttribute("newUser") User user){
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleService.getRole("USER"));
        user.setRoles(roleSet);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return "redirect:/admin/users-manage";
    }
}