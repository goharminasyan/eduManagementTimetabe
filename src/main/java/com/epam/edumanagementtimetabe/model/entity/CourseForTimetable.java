package com.epam.edumanagementtimetabe.model.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "courses_table")
public class CourseForTimetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinTable(
            name="courses_table",
            joinColumns = @JoinColumn( name="id"),
            inverseJoinColumns = @JoinColumn( name="academic_course_id")
    )
    private List<AcademicCourse> academicCourse;

    @OneToMany
    @JoinTable(
            name="courses_table",
            joinColumns = @JoinColumn( name="id"),
            inverseJoinColumns = @JoinColumn( name="academic_class_id")
    )
    private List<AcademicClass> academicClassSet;

    @NotBlank(message = "Please, fill the required fields")
    @Size(max = 50, message = "Symbols can't be more than 50")
    private String dayOfWeek;

    public CourseForTimetable() {
    }

    public CourseForTimetable(Long id, List<AcademicCourse> academicCourse, List<AcademicClass> academicClassSet, String dayOfWeek) {
        this.id = id;
        this.academicCourse = academicCourse;
        this.academicClassSet = academicClassSet;
        this.dayOfWeek = dayOfWeek;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<AcademicCourse> getAcademicCourse() {
        return academicCourse;
    }

    public void setAcademicCourse(List<AcademicCourse> academicCourse) {
        this.academicCourse = academicCourse;
    }

    public List<AcademicClass> getAcademicClassSet() {
        return academicClassSet;
    }

    public void setAcademicClassSet(List<AcademicClass> academicClassSet) {
        this.academicClassSet = academicClassSet;
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
        CourseForTimetable that = (CourseForTimetable) o;
        return Objects.equals(id, that.id) && Objects.equals(academicCourse, that.academicCourse) && Objects.equals(academicClassSet, that.academicClassSet) && Objects.equals(dayOfWeek, that.dayOfWeek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, academicCourse, academicClassSet, dayOfWeek);
    }

    @Override
    public String toString() {
        return "CourseForTimetable{" +
                "id=" + id +
                ", academicCourse=" + academicCourse +
                ", academicClassSet=" + academicClassSet +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                '}';
    }
}
