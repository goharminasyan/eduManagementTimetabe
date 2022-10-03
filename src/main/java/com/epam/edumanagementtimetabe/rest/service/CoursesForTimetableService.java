package com.epam.edumanagementtimetabe.rest.service;


import com.epam.edumanagementtimetabe.model.entity.CoursesForTimetable;

import java.util.List;

public interface CoursesForTimetableService {
    List<Long> getCoursesForMonday();

    void create(CoursesForTimetable coursesForTimetable);
}
