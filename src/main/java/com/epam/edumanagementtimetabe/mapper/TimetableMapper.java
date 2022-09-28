package com.epam.edumanagementtimetabe.mapper;

import com.epam.edumanagementtimetabe.model.dto.TimetableDto;
import com.epam.edumanagementtimetabe.model.entity.Timetable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TimetableMapper {

    public static Timetable toTimetable(TimetableDto timetableDto) {
        Timetable timetable = new Timetable();
        timetable.setId(timetableDto.getId());
        timetable.setDay(timetableDto.getDay());
        timetable.setAcademicClass(timetableDto.getAcademicClass());
        timetable.setCourse(timetableDto.getCourse());
        return timetable;
    }

    public static TimetableDto toDto(Timetable teacher) {
        TimetableDto timetableDto = new TimetableDto();
        timetableDto.setId(teacher.getId());
        timetableDto.setCourse(teacher.getCourse());
        timetableDto.setDay(teacher.getDay());
        timetableDto.setAcademicClass(teacher.getAcademicClass());
        return timetableDto;
    }

    public static List<TimetableDto> toListOfTimetablesDto(List<Timetable> timetables) {
        List<TimetableDto> timetableDtoList = new ArrayList<>();
        for (Timetable timetable : timetables) {
            timetableDtoList.add(toDto(timetable));
        }
        return timetableDtoList;
    }

    public static List<Timetable> toListOfTimetables(List<TimetableDto> timetableDtoList) {
        List<Timetable> timetables = new ArrayList<>();
        for (TimetableDto timetableDto : timetableDtoList) {
            timetables.add(toTimetable(timetableDto));
        }
        return timetables;
    }
}
