package io.nikiforov.edu.controller;

import io.nikiforov.edu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
    @Autowired
	private CourseService courseService;

    @GetMapping("/")
    public String homePage(){
        return "redirect:/all-courses";
    }
	
}
