package io.nikiforov.edu.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @GetMapping("/admin")
    @ResponseBody
    public String securedPage(){
        return "Secured page";
    }

    @PreAuthorize("hasAnyRole('USER')")
    @ResponseBody
    @GetMapping("/pageForUsers")
    public String securedTestPage(){
        return "Only User can see this";
    }
}