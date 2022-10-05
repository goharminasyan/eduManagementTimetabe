package com.epam.edumanagementtimetabe.model.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "academic_course")
public class AcademicCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50, message = "Symbols can't be more than 50")
    @Column(unique = true)
    @NotBlank(message = "Please, fill the required fields")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    @NotNull(message = "Please, fill the required fields")
    private Subject subject;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<CoursesForTimetable> coursesForTimetableCourses = new ArrayList<>();


    public AcademicCourse() {
    }

    public AcademicCourse(String name, Subject subject, List<CoursesForTimetable> coursesForTimetableCourses) {
        this.name = name;
        this.subject = subject;
        this.coursesForTimetableCourses = coursesForTimetableCourses;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<CoursesForTimetable> getCoursesForTimetableCourses() {
        return coursesForTimetableCourses;
    }

    public void setCoursesForTimetableCourses(List<CoursesForTimetable> coursesForTimetableCourses) {
        this.coursesForTimetableCourses = coursesForTimetableCourses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcademicCourse that = (AcademicCourse) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(subject, that.subject) && Objects.equals(coursesForTimetableCourses, that.coursesForTimetableCourses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, subject, coursesForTimetableCourses);
    }

    @Override
    public String toString() {
        return "AcademicCourse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject=" + subject +
                ", coursesForTimetableCourses=" + coursesForTimetableCourses +
                '}';
    }
}
