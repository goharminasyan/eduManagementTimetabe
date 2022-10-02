package com.epam.edumanagementtimetabe.rest.repository;

import com.epam.edumanagementtimetabe.model.entity.AcademicClass;
import com.epam.edumanagementtimetabe.model.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicClassRepository extends JpaRepository<AcademicClass, Long> {
    AcademicClass findAcademicClassByClassNumber(String name);
}
