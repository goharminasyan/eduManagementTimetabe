package com.epam.edumanagementtimetabe.rest.repository;

import com.epam.edumanagementtimetabe.model.entity.CoursesForTimetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CourseForTimetableRepository extends JpaRepository<CoursesForTimetable, Long> {

    List<CoursesForTimetable> findByDayOfWeek(String dayOfWeek);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "insert into courses_table(day_of_week, academic_course_id, academic_class_id) " +
            "values(?1,?2,?3)")
    void create(String dayOfWeek, Long academicCourseId, Long academicClassId);
}
