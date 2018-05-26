package io.nikiforov.edu.controller;

import io.nikiforov.edu.entity.Student;
import io.nikiforov.edu.entity.Teacher;
import io.nikiforov.edu.entity.User;
import io.nikiforov.edu.model.UserSettingsModel;
import io.nikiforov.edu.service.CourseService;
import io.nikiforov.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class MainController {
    @Autowired
	private CourseService courseService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String homePage(){
        return "redirect:/all-courses";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/user-page")
    public String userPage(@AuthenticationPrincipal UserDetails userDetails,
                           Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        for(GrantedAuthority authority : auth.getAuthorities()){
            if (authority.getAuthority().equals("ROLE_TEACHER")) {
                model.addAttribute("principal", (Teacher) auth.getPrincipal());
            } else if (authority.getAuthority().equals("ROLE_STUDENT")) {
                model.addAttribute("principal", (Student) auth.getPrincipal());
            }
        }
        model.addAttribute("userDetails", userDetails);
        return "userSettings";
    }

    @ResponseBody
    @PutMapping("/save-settings")
    public User saveSettings(@AuthenticationPrincipal UserDetails userDetails,
                             @RequestBody UserSettingsModel userSettingsModel) {
        return userService.saveUserSettings(userDetails, userSettingsModel);
    }

}
