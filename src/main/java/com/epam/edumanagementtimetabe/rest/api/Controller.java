package com.epam.edumanagementtimetabe.rest.api;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/timetable")
public class Controller {

    @GetMapping
    public String getAll(ModelMap modelMap) {
        return "timetable4";
    }
}
