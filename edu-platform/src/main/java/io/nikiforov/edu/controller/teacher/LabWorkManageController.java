package io.nikiforov.edu.controller.teacher;

import io.nikiforov.edu.model.LabWorkInfo;
import io.nikiforov.edu.service.CourseService;
import io.nikiforov.edu.service.LabWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LabWorkManageController {

    @Autowired
    LabWorkService labWorkService;

    @Autowired
    CourseService courseService;

    @PostMapping("/add-labwork")
    public String addLabWork(@ModelAttribute("newLabWorkInfo") LabWorkInfo labWorkInfo) {
        labWorkService.saveFromModel(labWorkInfo);
        return "redirect:/courses-manage/" + labWorkInfo.getCourseId();
    }

}
