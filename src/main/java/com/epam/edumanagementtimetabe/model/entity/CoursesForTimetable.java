package com.epam.edumanagementtimetabe.model.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "courses_table")
public class CoursesForTimetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="courses_table",
            joinColumns = @JoinColumn( name="id"),
            inverseJoinColumns = @JoinColumn( name="academic_course_id"))
    private List<AcademicCourse> academicCourse;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="courses_table",
            joinColumns = @JoinColumn( name="id"),
            inverseJoinColumns = @JoinColumn( name="academic_class_id"))
    private List<AcademicClass> academicClass;

    private String dayOfWeek;

    public CoursesForTimetable() {
    }

    public CoursesForTimetable( List<AcademicCourse> academicCourse, List<AcademicClass> academicClass, String dayOfWeek) {
        this.academicCourse = academicCourse;
        this.academicClass = academicClass;
        this.dayOfWeek = dayOfWeek;
    }

    public Long getId() {
        return id;
    }



    public List<AcademicCourse> getAcademicCourse() {
        return academicCourse;
    }

    public void setAcademicCourse(List<AcademicCourse> academicCourse) {
        this.academicCourse = academicCourse;
    }

    public List<AcademicClass> getAcademicClass() {
        return academicClass;
    }

    public void setAcademicClass(List<AcademicClass> academicClass) {
        this.academicClass = academicClass;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoursesForTimetable that = (CoursesForTimetable) o;
        return Objects.equals(id, that.id) && Objects.equals(academicCourse, that.academicCourse) && Objects.equals(academicClass, that.academicClass) && Objects.equals(dayOfWeek, that.dayOfWeek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, academicCourse, academicClass, dayOfWeek);
    }

    @Override
    public String toString() {
        return "CoursesForTimetable{" +
                "id=" + id +
                ", academicCourse=" + academicCourse +
                ", academicClassSet=" + academicClass +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                '}';
    }
}
