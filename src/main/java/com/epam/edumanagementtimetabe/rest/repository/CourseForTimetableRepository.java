package com.epam.edumanagementtimetabe.rest.repository;

import com.epam.edumanagementtimetabe.model.entity.AcademicCourse;
import com.epam.edumanagementtimetabe.model.entity.CourseForTimetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import static javax.persistence.criteria.JoinType.LEFT;

@Repository
public interface CourseForTimetableRepository extends JpaRepository<CourseForTimetable, Long> {

    @Query(nativeQuery = true,
            value = "SELECT courses_table.academic_course_id " +
                    "FROM courses_table WHERE courses_table.day_of_week ='Monday';")
    List<Long> getCoursesForMonday();
}
