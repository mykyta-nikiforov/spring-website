package io.nikiforov.edu.controller.teacher;

import io.nikiforov.edu.entity.Course;
import io.nikiforov.edu.entity.LabWork;
import io.nikiforov.edu.model.LabWorkInfo;
import io.nikiforov.edu.service.CourseService;
import io.nikiforov.edu.service.LabWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LabWorkManageController {

    @Autowired
    LabWorkService labWorkService;

    @Autowired
    CourseService courseService;

    @ResponseBody
    @PostMapping("/add-labwork")
    public LabWork addLabWork(@RequestBody LabWorkInfo labWorkInfo) {
        return labWorkService.saveFromModel(labWorkInfo);
    }

    @GetMapping("/edit-labwork/{id}")
    public String editLabWork(@PathVariable("id") int id, Model model) {
        model.addAttribute("labWork",
                new LabWorkInfo(labWorkService.getLabWork(id)));
        return "teacher/labWorkEdit";
    }

    @ResponseBody
    @RequestMapping(value = "/delete-labwork/{id}", method = RequestMethod.DELETE)
    public String deleteLabWork(@PathVariable("id") int id) {
        Course course = courseService.getCourseByLabWorkId(id);
        labWorkService.deleteLabWork(id);
        System.out.println(course);
        return "deleted";
    }

    @PostMapping("update-labwork")
    public String updateLabWork(@ModelAttribute("labWork") LabWorkInfo labWorkInfo) {
        labWorkService.saveFromModel(labWorkInfo);
        return "redirect:/edit-labwork/" + labWorkInfo.getId();
    }
}