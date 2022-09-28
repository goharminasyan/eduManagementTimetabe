package com.epam.edumanagementtimetabe.rest.repository;

import com.epam.edumanagementtimetabe.model.entity.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable, Long> {

}
