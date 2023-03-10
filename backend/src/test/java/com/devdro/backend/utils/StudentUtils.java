package com.devdro.backend.utils;

import com.devdro.backend.model.Student;
import com.devdro.backend.web.dto.StudentCreateDto;
import com.devdro.backend.web.dto.StudentDto;
import java.time.LocalDate;
import java.time.Month;

public class StudentUtils {

  public static Student getStudent(boolean withId) {
    Student student = Student.builder()
        .firstName("John")
        .lastName("Doe")
        .dateOfBirth(LocalDate.of(1998, Month.MAY, 15))
        .address("Address")
        .email("example@devdro.com")
        .phoneNumber("62999888777")
        .build();

    if (withId) {
      student.setId(1L);
    }

    return student;
  }

  public static StudentDto getStudentDto(boolean withId) {
    StudentDto studentDto = StudentDto.builder()
        .firstName("John")
        .lastName("Doe")
        .dateOfBirth(LocalDate.of(1998, Month.MAY, 15))
        .address("Address")
        .email("example@devdro.com")
        .phoneNumber("62999888777")
        .build();

    if (withId) {
      studentDto.setId(1L);
    }

    return studentDto;
  }

  public static StudentCreateDto getStudentCreateDto() {
    return StudentCreateDto.builder()
        .firstName("John")
        .lastName("Doe")
        .dateOfBirth(LocalDate.of(1998, Month.MAY, 15))
        .gender("Male")
        .email("example@devdro.com")
        .phoneNumber("62999888777")
        .address("Address")
        .build();
  }
}
