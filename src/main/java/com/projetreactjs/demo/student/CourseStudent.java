package com.projetreactjs.demo.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;
@Data
@AllArgsConstructor
@Builder(builderClassName = "CourseStudentBuider")
@JsonDeserialize(builder =CourseStudent.CourseStudentBuider.class)
public class CourseStudent {
    @JsonProperty("id_student")
    private final UUID id_student;
    @JsonProperty("course_id")
  private  final UUID course_id;
    @JsonProperty("start_date")
  private final LocalDate start_date;
    @JsonProperty("end_date")
  private  final LocalDate end_date;
    @JsonProperty("grade")
  private final Integer grade;
}
