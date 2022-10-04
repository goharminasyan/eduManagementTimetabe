package com.epam.edumanagementtimetabe.rest.service;

import com.epam.edumanagementtimetabe.model.dto.TimetableDto;
import com.epam.edumanagementtimetabe.model.entity.Timetable;

import java.util.List;

public interface TimetableService {

    List<Timetable> findAll();

    void create(TimetableDto timetableDto);

    void delete(Long id);

    Timetable getById(Long id);

}
