package com.example.exammanagement.entity;

import com.example.exammanagement.enums.Semester;
import com.example.exammanagement.utility.entity.CoreEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Course extends CoreEntity {
    String name;

    @Enumerated(value = EnumType.STRING)
    Semester semester;
}
