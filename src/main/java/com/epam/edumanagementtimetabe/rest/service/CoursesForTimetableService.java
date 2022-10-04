package com.epam.edumanagementtimetabe.rest.service;


import com.epam.edumanagementtimetabe.model.dto.CoursesForTimetableDto;
import com.epam.edumanagementtimetabe.model.entity.CoursesForTimetable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CoursesForTimetableService {
    List<CoursesForTimetable> getCoursesForMonday(String dayOfWeek);

    void create(CoursesForTimetableDto coursesForTimetableDto);

    @Transactional
    void delete(Long id);
}