package com.epam.edumanagementtimetabe.model.dto;

import com.epam.edumanagementtimetabe.model.entity.AcademicClass;
import com.epam.edumanagementtimetabe.model.entity.Course;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.Objects;

public class TimetableDto {

    private Long id;

    @Enumerated(value = EnumType.STRING)
    private DayOfWeek day;

    private AcademicClass academicClass;

    private Course course;

    public TimetableDto() {
    }

    public TimetableDto(Long id, DayOfWeek day, AcademicClass academicClass, Course course) {
        this.id = id;
        this.day = day;
        this.academicClass = academicClass;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public AcademicClass getAcademicClass() {
        return academicClass;
    }

    public void setAcademicClass(AcademicClass academicClass) {
        this.academicClass = academicClass;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimetableDto that = (TimetableDto) o;
        return Objects.equals(id, that.id) && day == that.day && Objects.equals(academicClass, that.academicClass) && Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, day, academicClass, course);
    }

    @Override
    public String toString() {
        return "TimetableDto{" +
                "id=" + id +
                ", day=" + day +
                ", academicClass=" + academicClass +
                ", course=" + course +
                '}';
    }
}
