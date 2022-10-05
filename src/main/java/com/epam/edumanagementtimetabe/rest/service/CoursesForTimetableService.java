package com.epam.edumanagementtimetabe.rest.service;


import com.epam.edumanagementtimetabe.model.dto.CoursesForTimetableDto;
import com.epam.edumanagementtimetabe.model.entity.CoursesForTimetable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CoursesForTimetableService {
    List<CoursesForTimetable> getCoursesForMonday(String dayOfWeek);

    void create(CoursesForTimetableDto coursesForTimetableDto);

    //    @Modifying
//    @Query(nativeQuery = true, value = "UPDATE courses_table SET day_of_week = 'Not defined' WHERE courses_table.id =(?1);")
    void renameById( Long id);
}