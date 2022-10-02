package com.epam.edumanagementtimetabe.rest.service;

import com.epam.edumanagementtimetabe.model.dto.AcademicClassDto;
import com.epam.edumanagementtimetabe.model.entity.AcademicClass;

import java.util.List;

public interface AcademicClassService {

    void create(AcademicClass academicClass);

    List<AcademicClassDto> findAll();

    AcademicClassDto getById(Long id);

    AcademicClass findByName(String name);
}


