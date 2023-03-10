package com.devdro.backend.web.dto;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseCreateDto {

  @NotBlank(message = "Name is required")
  private String name;

  @NotNull(message = "Start Date is required")
  private LocalDate startDate;

  @NotNull(message = "Duration is required")
  private Integer duration;
}
