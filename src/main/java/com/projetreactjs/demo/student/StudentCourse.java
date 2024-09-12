package com.projetreactjs.demo.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;
@Builder(builderClassName = "StudentCourseBuilder")
@JsonDeserialize(builder = StudentCourse.StudentCourseBuilder.class)
@AllArgsConstructor
@Data
public class StudentCourse {

    @JsonProperty("idStudent")
    private  final UUID idStudent ;
    @JsonProperty("courseId")
    private  final  UUID courseId;
    @JsonProperty("startDate")
    private  final LocalDate startDate;
    @JsonProperty("endDate")
    private  final  LocalDate endDate;
    @JsonProperty("teacherName")
    private  final String teacherName;
    @JsonProperty("departement")
    private final  String departement;
    @JsonProperty("description")
    private  final String description;
    @JsonProperty("name")
    private  final  String name;
    @JsonProperty("grade")
    private final  Integer grade;


}
