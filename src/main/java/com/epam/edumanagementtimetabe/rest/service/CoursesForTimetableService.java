package com.epam.edumanagementtimetabe.rest.service;


import com.epam.edumanagementtimetabe.model.dto.CoursesForTimetableDto;
import com.epam.edumanagementtimetabe.model.entity.CoursesForTimetable;

import java.util.List;

public interface CoursesForTimetableService {
    List<CoursesForTimetable> getCoursesForMonday(String dayOfWeek);

    void create(CoursesForTimetableDto coursesForTimetableDto);

    void renameById(Long id);
}