package com.epam.edumanagementtimetabe.rest.repository;

import com.epam.edumanagementtimetabe.model.entity.CoursesForTimetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseForTimetableRepository extends JpaRepository<CoursesForTimetable, Long> {

    @Query(nativeQuery = true,
            value = "SELECT courses_table.academic_course_id " +
                    "FROM courses_table WHERE courses_table.day_of_week ='Monday';")
    List<Long> getCoursesForMonday();
}
