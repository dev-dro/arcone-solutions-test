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
@NoArgsConstructor
@AllArgsConstructor
public class StudentCreateDto {

  @NotBlank(message = "First Name is required")
  private String firstName;

  @NotBlank(message = "Last Name is required")
  private String lastName;

  @NotNull(message = "Date of Birth is required")
  private LocalDate dateOfBirth;

  private String gender;

  @NotBlank(message = "Email is required")
  private String email;

  @NotBlank(message = "Phone Number is required")
  private String phoneNumber;

  @NotBlank(message = "Address is required")
  private String address;
}
