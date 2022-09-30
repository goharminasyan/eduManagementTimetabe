package com.epam.edumanagementtimetabe.rest.service;


import com.epam.edumanagementtimetabe.model.dto.TeacherDto;
import com.epam.edumanagementtimetabe.model.entity.Teacher;

import java.util.List;

public interface TeacherService {
    void create(TeacherDto teacherDto);

    List<TeacherDto> findAll();

    Teacher getTeacherById(Long id);

//    Teacher findByUserId(Long id);
}
