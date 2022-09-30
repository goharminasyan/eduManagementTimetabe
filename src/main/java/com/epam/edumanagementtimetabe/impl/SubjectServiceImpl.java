package com.epam.edumanagementtimetabe.impl;

import com.epam.edumanagementtimetabe.model.entity.Subject;
import com.epam.edumanagementtimetabe.model.entity.Teacher;
import com.epam.edumanagementtimetabe.rest.repository.SubjectRepository;
import com.epam.edumanagementtimetabe.rest.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public void create(Subject subject) {
        if (subject != null) {
            subjectRepository.save(subject);
        }
    }

    @Override
    public Subject findSubjectBySubjectName(String name) {
        return subjectRepository.findSubjectByName(name);
    }

    @Override
    public Set<Teacher> findAllTeachers(String name) {
        return findSubjectBySubjectName(name).getTeacherSet();
    }

    @Override
    public void update(Subject subject) {
        Subject subjectBySubjectName = findSubjectBySubjectName(subject.getName());
        if (subject.getName() != null) {
            subjectBySubjectName.setName(subject.getName());
        }
        if (subject.getTeacherSet() != null) {
            Set<Teacher> teacherSet = subject.getTeacherSet();
            for (Teacher teacher : teacherSet) {
                subjectBySubjectName.getTeacherSet().add(teacher);
            }
        }
        create(subjectBySubjectName);
    }
}

