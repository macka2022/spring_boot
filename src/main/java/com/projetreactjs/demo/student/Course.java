package com.projetreactjs.demo.student;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder(builderClassName = "CourseBuilder")
@JsonDeserialize(builder = Course.CourseBuilder.class)
@AllArgsConstructor
@Data
public class Course {
    @JsonProperty("courseId")
    private  final UUID courseId;
    @JsonProperty("name")
    private final  String name;
    @JsonProperty("teacherName")
    private final String teacherName;
    @JsonProperty("departement")
    private final String departement ;
    @JsonProperty("description")
    private final String description;
}
