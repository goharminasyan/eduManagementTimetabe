package com.epam.edumanagementtimetabe.impl;

import com.epam.edumanagementtimetabe.model.dto.CoursesForTimetableDto;
import com.epam.edumanagementtimetabe.model.entity.AcademicClass;
import com.epam.edumanagementtimetabe.model.entity.CoursesForTimetable;
import com.epam.edumanagementtimetabe.rest.repository.AcademicClassRepository;
import com.epam.edumanagementtimetabe.rest.repository.CourseForTimetableRepository;
import com.epam.edumanagementtimetabe.rest.service.CoursesForTimetableService;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CoursesForTimetableServiceImpl implements CoursesForTimetableService {

    private final CourseForTimetableRepository repository;
    private final AcademicClassRepository academicClassRepository;

    public CoursesForTimetableServiceImpl(CourseForTimetableRepository repository, AcademicClassRepository academicClassRepository) {
        this.repository = repository;
        this.academicClassRepository = academicClassRepository;
    }

    @Override
    public List<CoursesForTimetable> getCoursesForMonday(String dayOfWeek) {
        return repository.findByDayOfWeek(dayOfWeek);
    }

    @Override
    public void create(CoursesForTimetableDto coursesForTimetableDto) {
        repository.create(coursesForTimetableDto.getDayOfWeek(), coursesForTimetableDto.getAcademicCourse().getId(), coursesForTimetableDto.getAcademicClass().getId());
    }


    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}