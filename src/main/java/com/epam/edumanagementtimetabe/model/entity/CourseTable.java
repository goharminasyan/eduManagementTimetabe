package com.epam.edumanagementtimetabe.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "course_table")
public class CourseTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private AcademicCourse academicCourse;

    public CourseTable(Long id, AcademicCourse academicCourse) {
        this.id = id;
        this.academicCourse = academicCourse;
    }

    public CourseTable() {
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


}
