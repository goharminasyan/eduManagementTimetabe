package com.epam.edumanagementtimetabe.impl;

import com.epam.edumanagementtimetabe.model.dto.CoursesForTimetableDto;
import com.epam.edumanagementtimetabe.model.entity.CoursesForTimetable;
import com.epam.edumanagementtimetabe.rest.repository.AcademicClassRepository;
import com.epam.edumanagementtimetabe.rest.repository.CoursesForTimetableRepository;
import com.epam.edumanagementtimetabe.rest.service.CoursesForTimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CoursesForTimetableServiceImpl implements CoursesForTimetableService {

    private final CoursesForTimetableRepository coursesRepository;

    @Autowired
    public CoursesForTimetableServiceImpl(CoursesForTimetableRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    @Transactional
    @Override
    public List<CoursesForTimetable> getCoursesForMonday(String dayOfWeek) {
        return coursesRepository.findByDayOfWeek(dayOfWeek);
    }

    @Transactional
    @Override
    public void create(CoursesForTimetableDto coursesForTimetableDto) {
        coursesRepository.create(coursesForTimetableDto.getDayOfWeek(),
                coursesForTimetableDto.getAcademicCourse().getName(),
                coursesForTimetableDto.getAcademicClass().getId());
    }

    @Transactional
    @Override
    public void renameById(Long id) {
        coursesRepository.renameById(id);
    }


    @Transactional
    @Override
    public void delete(Long id) {
        coursesRepository.delete(id);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        renameById(id);
        delete(id);
    }
}