package com.epam.edumanagementtimetabe.rest.api;

import com.epam.edumanagementtimetabe.model.dto.CoursesForTimetableDto;
import com.epam.edumanagementtimetabe.rest.service.AcademicClassService;
import com.epam.edumanagementtimetabe.rest.service.AcademicCourseService;
import com.epam.edumanagementtimetabe.rest.service.CoursesForTimetableService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/timetable")
public class TimetableController {

    private final AcademicCourseService academicCourseService;
    private final CoursesForTimetableService courseService;
    private final AcademicClassService academicClassService;

    public TimetableController(AcademicCourseService academicCourseService, CoursesForTimetableService courseService, AcademicClassService academicClassService) {
        this.academicCourseService = academicCourseService;
        this.courseService = courseService;
        this.academicClassService = academicClassService;
    }

    @GetMapping("/creation")
    public String get4_1(Model model) {
        model.addAttribute("courses", academicCourseService.findAll());
        model.addAttribute("courseForTable", new CoursesForTimetableDto());
        model.addAttribute("academicClass", academicClassService.findByName("5A"));
        model.addAttribute("lessonsOfMonday",courseService.getCoursesForMonday("Monday"));
        return "timetable4-1";
    }

    @PostMapping("/creation")
    public String post4_1(@ModelAttribute("courseForTable") @Valid CoursesForTimetableDto coursesForTimetableDto,
                          BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("courses", academicCourseService.findAll());
            model.addAttribute("academicClass", academicClassService.findByName("5A"));
            return "timetable4-1";
        }

        model.addAttribute("courses", academicCourseService.findAll());
        coursesForTimetableDto.setDayOfWeek(coursesForTimetableDto.getDayOfWeek());
        courseService.create(coursesForTimetableDto);
        model.addAttribute("lessonsOfMonday",courseService.getCoursesForMonday("Monday"));
        model.addAttribute("academicClass", academicClassService.findByName("5A"));
        return "timetable4-1";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        if (id != null) {
            courseService.delete(id);
        }
        model.addAttribute("lessonsOfMonday",courseService.getCoursesForMonday("Monday"));
        return "timetable4-1";
    }

    @GetMapping
    public String get4(ModelMap modelMap) {
        modelMap.addAttribute("timetable", "timetable");
        return "timetable4";
    }
}
