package com.epam.edumanagementtimetabe.rest.api;

import com.epam.edumanagementtimetabe.model.entity.CourseForTimetable;
import com.epam.edumanagementtimetabe.rest.service.AcademicCourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("/timetable")
public class TimetableController {

    Map<Integer, CourseForTimetable> monday = new LinkedHashMap<>();
    Integer key =0;

    AcademicCourseService academicCourseService;

    public TimetableController(AcademicCourseService academicCourseService) {
        this.academicCourseService = academicCourseService;
    }


    @GetMapping("/creation")
    public String get4_1(Model model) {
        model.addAttribute("courses", academicCourseService.findAll());
        model.addAttribute("table", new CourseForTimetable());
        model.addAttribute("lessons", monday);
        return "timetable4-1";
    }

    @PostMapping("/creation")
    public String post4_1(@ModelAttribute("table") @Valid CourseForTimetable table,
                          BindingResult result, Model model) {
        monday.put(++key, table);
        model.addAttribute("courses", academicCourseService.findAll());
        model.addAttribute("lessons", monday);
        return "timetable4-1";
    }


    @GetMapping("/success")
    public String get4_1_1() {
        return "timetable4-1-1";
    }

    @GetMapping
    public String get4(ModelMap modelMap) {
        modelMap.addAttribute("timetable", "timetable");
        return "timetable4";
    }
}
