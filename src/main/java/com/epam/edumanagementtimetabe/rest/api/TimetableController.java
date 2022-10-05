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
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/timetable")
public class TimetableController {

    private final AcademicCourseService academicCourseService;
    private final CoursesForTimetableService coursesService;
    private final AcademicClassService academicClassService;


    public TimetableController(AcademicCourseService academicCourseService,
                               CoursesForTimetableService coursesService,
                               AcademicClassService academicClassService) {

        this.academicCourseService = academicCourseService;
        this.coursesService = coursesService;
        this.academicClassService = academicClassService;
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
        model.addAttribute("lessonsOfMonday",courseService.getCoursesForMonday("Monday"));
        model.addAttribute("timetable", new TimetableDto());
        model.addAttribute("lessonsOfMonday", courseService.getCoursesForMonday("Monday"));

        return "timetable4-1";
    }

    @PostMapping()
    public String createTimetable(@ModelAttribute("timetable")  TimetableDto timetableDto,
                                  @RequestParam("class") String thisClass, Model model) {
        AcademicClass byName = academicClassService.findByName(thisClass);
        timetableDto.setAcademicClass(byName);
        timetableService.create(timetableDto);
        model.addAttribute("lessonsOfMonday", courseService.getCoursesForMonday("Monday"));
        return "redirect:/timetable";
    }

    @PostMapping("/creation")
    public String post4_1(@ModelAttribute("courseForTable") CoursesForTimetableDto coursesForTimetableDto,
                          @RequestParam("nameOfDay") String nameOfDay, @RequestParam("class") String thisClass,
                          BindingResult result, Model model) {
    public String post4_1(@ModelAttribute("courseForTable") @Valid CoursesForTimetableDto coursesForTimetableDto,
                          BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("courses", academicCourseService.findAll());
            model.addAttribute("academicClass", academicClassService.findByName("5A"));
            return "timetable4-1";
        }

        model.addAttribute("courses", academicCourseService.findAll());
        AcademicClass byName = academicClassService.findByName(thisClass);
        coursesForTimetableDto.setDayOfWeek(nameOfDay);
        coursesForTimetableDto.setAcademicClass(byName);

        coursesService.create(coursesForTimetableDto);
        model.addAttribute("lessonsOfMonday",coursesService.getCoursesForMonday("Monday"));

        coursesForTimetableDto.setDayOfWeek(coursesForTimetableDto.getDayOfWeek());
        courseService.create(coursesForTimetableDto);
        model.addAttribute("lessonsOfMonday",courseService.getCoursesForMonday("Monday"));
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
