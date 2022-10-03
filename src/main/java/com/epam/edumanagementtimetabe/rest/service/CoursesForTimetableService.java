package com.epam.edumanagementtimetabe.rest.service;


import com.epam.edumanagementtimetabe.model.dto.CoursesForTimetableDto;

import java.util.List;

public interface CoursesForTimetableService {
    List<Long> getCoursesForMonday();

    void create(CoursesForTimetableDto coursesForTimetableDto);
}