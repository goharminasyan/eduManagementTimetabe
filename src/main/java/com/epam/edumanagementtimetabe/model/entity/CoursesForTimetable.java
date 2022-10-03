package com.epam.edumanagementtimetabe.model.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "courses_table")
public class CoursesForTimetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private AcademicCourse academicCourse;

    @OneToOne
    private AcademicClass academicClass;

    @NotBlank(message = "Please, fill the required fields")
    @Size(max = 50, message = "Symbols can't be more than 50")
    private String dayOfWeek;

    public CoursesForTimetable() {
    }

    public CoursesForTimetable(Long id, AcademicCourse academicCourse, AcademicClass academicClass, String dayOfWeek) {
        this.id = id;
        this.academicCourse = academicCourse;
        this.academicClass = academicClass;
        this.dayOfWeek = dayOfWeek;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AcademicCourse getAcademicCourse() {
        return academicCourse;
    }

    public void setAcademicCourse(AcademicCourse academicCourse) {
        this.academicCourse = academicCourse;
    }

    public AcademicClass getAcademicClass() {
        return academicClass;
    }

    public void setAcademicClass(AcademicClass academicClass) {
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
                ", academicClass=" + academicClass +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                '}';
    }
}
