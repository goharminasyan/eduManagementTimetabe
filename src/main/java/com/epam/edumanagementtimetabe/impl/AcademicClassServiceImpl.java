package com.epam.edumanagementtimetabe.impl;

import com.epam.edumanagementtimetabe.mapper.AcademicClassMapper;
import com.epam.edumanagementtimetabe.model.dto.AcademicClassDto;
import com.epam.edumanagementtimetabe.model.entity.AcademicClass;
import com.epam.edumanagementtimetabe.rest.repository.AcademicClassRepository;
import com.epam.edumanagementtimetabe.rest.service.AcademicClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcademicClassServiceImpl implements AcademicClassService {

    private final AcademicClassRepository academicClassRepository;

    @Autowired
    public AcademicClassServiceImpl(AcademicClassRepository academicClassRepository) {
        this.academicClassRepository = academicClassRepository;
    }

    @Override
    public void create(AcademicClass academicClass) {
        academicClassRepository.save(academicClass);
    }

    @Override
    public AcademicClassDto getById(Long id) {
        Optional<AcademicClass> classById = academicClassRepository.findById(id);
        if (classById.isPresent()) {
            return AcademicClassMapper.toDto(classById.get());
        }
        return new AcademicClassDto();
    }

    @Override
    public List<AcademicClassDto> findAll() {
        List<AcademicClass> academicClassList = academicClassRepository.findAll();
        return AcademicClassMapper.academicClassDtoList(academicClassList);
    }
}
