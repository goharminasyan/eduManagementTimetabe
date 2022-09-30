package com.epam.edumanagementtimetabe.rest.service;

import com.epam.edumanagementtimetabe.model.entity.Subject;
import com.epam.edumanagementtimetabe.model.entity.Teacher;

import java.util.List;
import java.util.Set;

public interface SubjectService {

    List<Subject> findAll();

    void create(Subject subject);

    Set<Teacher> findAllTeachers(String name);

    Subject findSubjectBySubjectName(String name);

    void update(Subject subject);
}
