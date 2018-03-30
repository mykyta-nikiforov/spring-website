package io.nikiforov.edu.controller;

import io.nikiforov.edu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
	private CourseService courseService;

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
        model.addAttribute("userDetails", userDetails);
        return "userPage";
    }

}
