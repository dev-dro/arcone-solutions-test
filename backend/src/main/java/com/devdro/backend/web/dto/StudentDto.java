package com.devdro.backend.web.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

  private Long id;
  private String firstName;
  private String lastName;
  private LocalDate dateOfBirth;
  private String address;
  private String email;
  private String phoneNumber;
}
