package com.epam.edumanagementtimetabe.rest.api;

import com.epam.edumanagementtimetabe.model.dto.CoursesForTimetableDto;
import com.epam.edumanagementtimetabe.model.entity.AcademicClass;
import com.epam.edumanagementtimetabe.model.entity.CoursesForTimetable;
import com.epam.edumanagementtimetabe.rest.service.AcademicClassService;
import com.epam.edumanagementtimetabe.rest.service.AcademicCourseService;
import com.epam.edumanagementtimetabe.rest.service.CoursesForTimetableService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

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
        model.addAttribute("lessonsOfMonday",courseService.getCoursesForMonday("Monday"));
        return "timetable4-1";
    }

    @PostMapping("/creation")
    public String post4_1(@ModelAttribute("courseForTable") CoursesForTimetableDto coursesForTimetableDto,
                          @RequestParam("nameOfDay") String nameOfDay, @RequestParam("class") String thisClass, BindingResult result, Model model) {

        model.addAttribute("courses", academicCourseService.findAll());
        AcademicClass byName = academicClassService.findByName(thisClass);
        coursesForTimetableDto.setDayOfWeek(nameOfDay);
        coursesForTimetableDto.setAcademicClass(byName);
        courseService.create(coursesForTimetableDto);
        model.addAttribute("lessonsOfMonday",courseService.getCoursesForMonday("Monday"));
        return "timetable4-1";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        if (id != null) {
            courseService.delete(id);
        }
        return "timetable4-1";
    }

    @GetMapping
    public String get4(ModelMap modelMap) {
        modelMap.addAttribute("timetable", "timetable");
        return "timetable4";
    }
}
