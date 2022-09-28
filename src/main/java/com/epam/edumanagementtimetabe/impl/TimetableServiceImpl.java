package com.epam.edumanagementtimetabe.impl;

import com.epam.edumanagementtimetabe.model.entity.Timetable;
import com.epam.edumanagementtimetabe.rest.repository.TimetableRepository;
import com.epam.edumanagementtimetabe.rest.service.TimetableService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimetableServiceImpl implements TimetableService {

    private final TimetableRepository timetableRepository;

    public TimetableServiceImpl(TimetableRepository timetableRepository) {
        this.timetableRepository = timetableRepository;
    }

    @Override
    public List<Timetable> findAll() {
        return timetableRepository.findAll();
    }

    @Override
    public void create(Timetable timetable) {
        timetableRepository.save(timetable);
    }

    @Override
    public void delete(Long id) {
        timetableRepository.deleteById(id);
    }

    @Override
    public Timetable getById(Long id) {
        return timetableRepository.findById(id).get();
    }
}
