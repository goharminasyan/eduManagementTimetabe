package com.epam.edumanagementtimetabe.rest.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/timetable")
public class TimetableController {

    @GetMapping
    public String get4() {
        return "timetable4";
    }

    @GetMapping("/creation")
    public String get4_1() {
        return "timetable4-1";
    }

    @GetMapping("/success")
    public String get4_1_1() {
        return "timetable4-1-1";
    }
}
