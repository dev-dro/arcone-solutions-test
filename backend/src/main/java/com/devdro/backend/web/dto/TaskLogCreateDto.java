package com.devdro.backend.web.dto;

import com.devdro.backend.model.EnrolledCourse;
import com.devdro.backend.model.TaskCategory;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskLogCreateDto {

  private LocalDate date;
  private EnrolledCourse enrolledCourse;
  private TaskCategory category;
  private String description;
  private Double timeSpent;
}
