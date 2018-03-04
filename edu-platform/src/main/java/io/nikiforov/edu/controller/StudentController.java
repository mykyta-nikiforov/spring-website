package io.nikiforov.edu.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

    @PreAuthorize("hasAnyRole('STUDENT')")
    @ResponseBody
    @GetMapping("/pageForStudents")
    public String securedTestPage(){
        return "Only Student can see this";
    }
}