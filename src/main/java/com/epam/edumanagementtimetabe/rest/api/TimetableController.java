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

import javax.validation.Valid;

@Controller
@RequestMapping("/timetable")
public class TimetableController {

    private final AcademicCourseService academicCourseService;
    private final CoursesForTimetableService coursesService;
    private final AcademicClassService academicClassService;
    private final TimetableService timetableService;


    public TimetableController(AcademicCourseService academicCourseService,
                               CoursesForTimetableService coursesService,
                               AcademicClassService academicClassService, TimetableService timetableService) {

        this.academicCourseService = academicCourseService;
        this.coursesService = coursesService;
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
        model.addAttribute("academicClass", academicClassService.findByName("5A"));
        model.addAttribute("lessonsOfMonday",coursesService.getCoursesForMonday("Monday"));
        model.addAttribute("timetable", new TimetableDto());

        return "timetable4-1";
    }

    @PostMapping()
    public String createTimetable(@ModelAttribute("timetable") @Valid TimetableDto timetableDto,
                                  @RequestParam("class") String thisClass, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("courseForTable", new CoursesForTimetableDto());
            model.addAttribute("timetable", new TimetableDto());
            model.addAttribute("academicClass", academicClassService.findByName("5A"));
            model.addAttribute("courses", academicCourseService.findAll());
            model.addAttribute("lessonsOfMonday", coursesService.getCoursesForMonday("Monday"));
            return "timetable4-1";
        }
        AcademicClass byName = academicClassService.findByName(thisClass);
        timetableDto.setAcademicClass(byName);
        timetableService.create(timetableDto);
        model.addAttribute("lessonsOfMonday", coursesService.getCoursesForMonday("Monday"));
        return "redirect:/timetable";
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

        coursesService.create(coursesForTimetableDto);
        model.addAttribute("lessonsOfMonday",coursesService.getCoursesForMonday("Monday"));
        model.addAttribute("academicClass", academicClassService.findByName("5A"));
        return "timetable4-1";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        if (id != null) {
            coursesService.renameById(id);
        }
        return "redirect:/timetable/creation";
    }
}
