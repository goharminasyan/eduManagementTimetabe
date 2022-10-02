package com.epam.edumanagementtimetabe.impl;

import com.epam.edumanagementtimetabe.model.entity.AcademicCourse;
import com.epam.edumanagementtimetabe.model.entity.CourseForTimetable;
import com.epam.edumanagementtimetabe.rest.repository.CourseForTimetableRepository;
import com.epam.edumanagementtimetabe.rest.service.CoursesForTimetableService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesForTimetableServiceImpl implements CoursesForTimetableService {

    private final CourseForTimetableRepository repository;

    public CoursesForTimetableServiceImpl(CourseForTimetableRepository repository) {
        this.repository = repository;
    }
    @Override
    public List<Long> getCoursesForMonday() {
        return repository.getCoursesForMonday();
    }

    @Override
    public void create(CourseForTimetable courseForTimetable) {
        repository.save(courseForTimetable);
    }
}
