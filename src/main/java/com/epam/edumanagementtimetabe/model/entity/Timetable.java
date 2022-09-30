package com.epam.edumanagementtimetabe.model.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.*;
import java.util.Objects;

@Entity
@Table(name = "timetable_table")
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Please, fill the required fields")
    private LocalDate startDate;

    @Column(name = "end_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Please, fill the required fields")
    private LocalDate endDate;

    @OneToOne
    private AcademicClass academicClass;

    @Column(name ="mondaylist", columnDefinition = "bigint array")
    private Integer[] mondaylist;

    @Column(name ="tuesdaylist", columnDefinition = "bigint array")
    private Integer[] tuesdaylist;

    @Column(name ="wednesdaylist", columnDefinition = "bigint array")
    private Integer[] wednesdaylist;

    @Column(name ="thursdaylist", columnDefinition = "bigint array")
    private Integer[] thursdaylist;

    @Column(name ="fridaylist", columnDefinition = "bigint array")
    private Integer[] fridaylist;

    @Column(name ="saturdaylist", columnDefinition = "bigint array")
    private Integer[] saturdaylist;

    @Column(name ="sundaylist", columnDefinition = "bigint array")
    private Integer[] sundaylist;

    public Timetable(Long id, AcademicClass academicClass, Integer[] mondaylist) {
        this.id = id;
        this.academicClass = academicClass;
        this.mondaylist = mondaylist;
    }

    public Timetable() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AcademicClass getAcademicClass() {
        return academicClass;
    }

    public void setAcademicClass(AcademicClass academicClass) {
        this.academicClass = academicClass;
    }

    public Integer[] getMondaylist() {
        return mondaylist;
    }

    public void setMondaylist(Integer[] mondaylist) {
        this.mondaylist = mondaylist;
    }

    public Integer[] getTuesdaylist() {
        return tuesdaylist;
    }

    public void setTuesdaylist(Integer[] tuesdaylist) {
        this.tuesdaylist = tuesdaylist;
    }

    public Integer[] getWednesdaylist() {
        return wednesdaylist;
    }

    public void setWednesdaylist(Integer[] wednesdaylist) {
        this.wednesdaylist = wednesdaylist;
    }

    public Integer[] getThursdaylist() {
        return thursdaylist;
    }

    public void setThursdaylist(Integer[] thursdaylist) {
        this.thursdaylist = thursdaylist;
    }

    public Integer[] getFridaylist() {
        return fridaylist;
    }

    public void setFridaylist(Integer[] fridaylist) {
        this.fridaylist = fridaylist;
    }

    public Integer[] getSaturdaylist() {
        return saturdaylist;
    }

    public void setSaturdaylist(Integer[] saturdaylist) {
        this.saturdaylist = saturdaylist;
    }

    public Integer[] getSundaylist() {
        return sundaylist;
    }

    public void setSundaylist(Integer[] sundaylist) {
        this.sundaylist = sundaylist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timetable timetable = (Timetable) o;
        return Objects.equals(id, timetable.id) && Objects.equals(academicClass, timetable.academicClass) && Arrays.equals(mondaylist, timetable.mondaylist) && Arrays.equals(tuesdaylist, timetable.tuesdaylist) && Arrays.equals(wednesdaylist, timetable.wednesdaylist) && Arrays.equals(thursdaylist, timetable.thursdaylist) && Arrays.equals(fridaylist, timetable.fridaylist) && Arrays.equals(saturdaylist, timetable.saturdaylist) && Arrays.equals(sundaylist, timetable.sundaylist);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, academicClass);
        result = 31 * result + Arrays.hashCode(mondaylist);
        result = 31 * result + Arrays.hashCode(tuesdaylist);
        result = 31 * result + Arrays.hashCode(wednesdaylist);
        result = 31 * result + Arrays.hashCode(thursdaylist);
        result = 31 * result + Arrays.hashCode(fridaylist);
        result = 31 * result + Arrays.hashCode(saturdaylist);
        result = 31 * result + Arrays.hashCode(sundaylist);
        return result;
    }

    @Override
    public String toString() {
        return "Timetable{" +
                "id=" + id +
                ", academicClass=" + academicClass +
                ", mondaylist=" + Arrays.toString(mondaylist) +
                ", tuesdaylist=" + Arrays.toString(tuesdaylist) +
                ", wednesdaylist=" + Arrays.toString(wednesdaylist) +
                ", thursdaylist=" + Arrays.toString(thursdaylist) +
                ", fridaylist=" + Arrays.toString(fridaylist) +
                ", saturdaylist=" + Arrays.toString(saturdaylist) +
                ", sundaylist=" + Arrays.toString(sundaylist) +
                '}';
    }
}
