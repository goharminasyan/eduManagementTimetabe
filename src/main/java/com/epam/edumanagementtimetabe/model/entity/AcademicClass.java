package com.epam.edumanagementtimetabe.model.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "academic_class")
public class AcademicClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50, message = "Symbols can't be more than 50")
    @Column(unique = true)
    @NotBlank(message = "Please, fill the required fields")
    private String classNumber;

    @ManyToMany( fetch = FetchType.EAGER)
    private List<CoursesForTimetable> coursesForTimetableList = new ArrayList<>();

    public AcademicClass(Long id, String classNumber, List<CoursesForTimetable> coursesForTimetableList) {
        this.id = id;
        this.classNumber = classNumber;
        this.coursesForTimetableList = coursesForTimetableList;
    }

    public AcademicClass() {
    }



    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public Long getId() {
        return id;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public List<CoursesForTimetable> getCoursesForTimetableList() {
        return coursesForTimetableList;
    }

    public void setCoursesForTimetableList(List<CoursesForTimetable> coursesForTimetableList) {
        this.coursesForTimetableList = coursesForTimetableList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcademicClass that = (AcademicClass) o;
        return Objects.equals(id, that.id) && Objects.equals(classNumber, that.classNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, classNumber);
    }

    @Override
    public String toString() {
        return "AcademicClass{" +
                "id=" + id +
                ", classNumber='" + classNumber + '\'' +
                '}';
    }
}
