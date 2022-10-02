package com.epam.edumanagementtimetabe.rest.service;


import com.epam.edumanagementtimetabe.model.entity.AcademicCourse;
import com.epam.edumanagementtimetabe.model.entity.CourseForTimetable;

import java.util.List;

public interface CoursesForTimetableService {
    List<Long> getCoursesForMonday();

    void create(CourseForTimetable courseForTimetable);
}
