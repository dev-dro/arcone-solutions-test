package com.devdro.backend.web.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {

  private Long id;
  private String name;
  private LocalDate startDate;
  private LocalDate endDate;
  private Double duration;
}
