package com.epam.edumanagementtimetabe.rest.api;

import com.epam.edumanagementtimetabe.model.entity.AcademicCourse;
import com.epam.edumanagementtimetabe.rest.service.AcademicCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/timetable")
public class TimetableController {

   AcademicCourseService academicCourseService;

    public TimetableController(AcademicCourseService academicCourseService) {
        this.academicCourseService = academicCourseService;
    }

    @GetMapping
    public String get4(ModelMap modelMap) {
        modelMap.addAttribute("timetable", "timetable");
        return "timetable4";
    }

    @GetMapping("/creation")
    public String get4_1(Model model) {
      model.addAttribute("courses", academicCourseService.findAll());
        return "timetable4-1";
    }

    @GetMapping("/success")
    public String get4_1_1() {
        return "timetable4-1-1";
    }
}
