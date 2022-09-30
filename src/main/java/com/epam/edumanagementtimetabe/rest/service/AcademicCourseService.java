package com.epam.edumanagementtimetabe.rest.service;


import com.epam.edumanagementtimetabe.model.dto.AcademicCourseDto;
import com.epam.edumanagementtimetabe.model.entity.AcademicCourse;

import java.util.List;

public interface AcademicCourseService {

    void create(AcademicCourse academicCourse);

    AcademicCourseDto getById(Long id);

    List<AcademicCourseDto> findAll();
}
