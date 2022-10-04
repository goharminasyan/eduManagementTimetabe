package com.epam.edumanagementtimetabe.rest.api;

import com.epam.edumanagementtimetabe.model.dto.CoursesForTimetableDto;
import com.epam.edumanagementtimetabe.model.dto.TimetableDto;
import com.epam.edumanagementtimetabe.model.entity.AcademicClass;
import com.epam.edumanagementtimetabe.rest.service.AcademicClassService;
import com.epam.edumanagementtimetabe.rest.service.AcademicCourseService;
import com.epam.edumanagementtimetabe.rest.service.CoursesForTimetableService;
import com.epam.edumanagementtimetabe.rest.service.TimetableService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/timetable")
public class TimetableController {

    private final AcademicCourseService academicCourseService;

    private final CoursesForTimetableService courseService;

    private final AcademicClassService academicClassService;

    private final TimetableService timetableService;

    public TimetableController(AcademicCourseService academicCourseService, CoursesForTimetableService courseService, AcademicClassService academicClassService, TimetableService timetableService) {
        this.academicCourseService = academicCourseService;
        this.courseService = courseService;
        this.academicClassService = academicClassService;
        this.timetableService = timetableService;
    }

    @GetMapping
    public String get4(Model model) {
        model.addAttribute("timetable", "timetable");
        return "timetable4";
    }

    @GetMapping("/creation")
    public String get4_1(Model model) {
        model.addAttribute("courses", academicCourseService.findAll());
        model.addAttribute("courseForTable", new CoursesForTimetableDto());
        model.addAttribute("timetable", new TimetableDto());
        model.addAttribute("lessonsOfMonday", courseService.getCoursesForMonday());
        return "timetable4-1";
    }

    @PostMapping()
    public String createTimetable(@ModelAttribute("timetable")  TimetableDto timetableDto,
                                  @RequestParam("class") String thisClass, Model model) {
        AcademicClass byName = academicClassService.findByName(thisClass);
        timetableDto.setAcademicClass(byName);
        timetableService.create(timetableDto);
        model.addAttribute("lessonsOfMonday", courseService.getCoursesForMonday());
        return "redirect:/timetable";
    }

    @PostMapping("/creation")
    public String post4_1(@ModelAttribute("courseForTable") CoursesForTimetableDto coursesForTimetableDto,
                          @RequestParam("nameOfDay") String nameOfDay, @RequestParam("class") String thisClass,
                          BindingResult result, Model model) {

        model.addAttribute("courses", academicCourseService.findAll());
        AcademicClass byName = academicClassService.findByName(thisClass);
        coursesForTimetableDto.setDayOfWeek(nameOfDay);
        coursesForTimetableDto.setAcademicClass(byName);
        courseService.create(coursesForTimetableDto);
        model.addAttribute("lessonsOfMonday", courseService.getCoursesForMonday());
        return "timetable4-1";
    }
}
