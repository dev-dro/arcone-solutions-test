package com.devdro.backend.web.dto;

import com.devdro.backend.model.Course;
import com.devdro.backend.model.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnrolledCourseCreateDto {

  private Student student;
  private Course course;
}
