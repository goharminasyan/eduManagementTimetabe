package com.epam.edumanagementtimetabe.rest.repository;

import com.epam.edumanagementtimetabe.model.entity.AcademicCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicCourseRepository extends JpaRepository<AcademicCourse, Long> {
  
}
