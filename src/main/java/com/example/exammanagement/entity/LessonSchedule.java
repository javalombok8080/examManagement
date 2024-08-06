package com.example.exammanagement.entity;

import com.example.exammanagement.enums.Semester;
import com.example.exammanagement.utility.entity.CoreEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "schedules")
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LessonSchedule extends CoreEntity {

    @Enumerated(value = EnumType.STRING)
    DayOfWeek dayOfWeek;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    LocalDate date;

    @DateTimeFormat(pattern = "hh:mm")
    LocalTime startTime;

    @DateTimeFormat(pattern = "hh:mm")
    LocalTime endTime;

    @Enumerated(value = EnumType.STRING)
    Semester semester;

    @ManyToMany
    @JoinTable(
            name = "schedule_course",
            joinColumns = @JoinColumn(name = "schedule_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    List<Course> courses;
}