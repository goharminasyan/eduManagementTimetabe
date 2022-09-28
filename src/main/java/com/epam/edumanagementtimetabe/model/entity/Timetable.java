package com.epam.edumanagementtimetabe.model.entity;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.Objects;

@Entity
@Table(name = "timetable_table")
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private DayOfWeek day;

    @OneToOne
    private AcademicClass academicClass;

    @ManyToOne
    private Course course;

    public Timetable(Long id, DayOfWeek day, AcademicClass academicClass, Course course) {
        this.id = id;
        this.day = day;
        this.academicClass = academicClass;
        this.course = course;
    }

    public Timetable() {
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
        Timetable timetable = (Timetable) o;
        return Objects.equals(id, timetable.id) && day == timetable.day && Objects.equals(academicClass, timetable.academicClass) && Objects.equals(course, timetable.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, day, academicClass, course);
    }

    @Override
    public String toString() {
        return "Timetable{" +
                "id=" + id +
                ", day=" + day +
                ", academicClass=" + academicClass +
                ", course=" + course +
                '}';
    }
}
