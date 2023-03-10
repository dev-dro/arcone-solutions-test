package com.devdro.backend.web.dto;

import com.devdro.backend.model.Course;
import com.devdro.backend.model.CourseStatus;
import com.devdro.backend.model.Student;
import com.devdro.backend.model.TaskLog;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnrolledCourseDto {

  private Long id;
  private Student student;
  private Course course;
  private List<TaskLog> taskLogs;
  private CourseStatus status;
  private Double totalTimeSpent;
}
