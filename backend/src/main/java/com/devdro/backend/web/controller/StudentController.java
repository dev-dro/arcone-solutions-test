package com.devdro.backend.web.controller;

import com.devdro.backend.exeption.ExistingEmailException;
import com.devdro.backend.exeption.MinimumAgeException;
import com.devdro.backend.exeption.StudentNotFoundException;
import com.devdro.backend.model.Student;
import com.devdro.backend.service.StudentService;
import com.devdro.backend.web.dto.StudentCreateDto;
import com.devdro.backend.web.dto.StudentDto;
import com.devdro.backend.web.mapper.StudentCreateDtoMapper;
import com.devdro.backend.web.mapper.StudentDtoStudentMapper;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

  private final StudentService studentService;

  @GetMapping("/{email}")
  @ResponseStatus(HttpStatus.OK)
  public StudentDto findStudentByEmail(@PathVariable String email) throws StudentNotFoundException {
    Student student = studentService.findStudent(email);
    return StudentDtoStudentMapper.INSTANCE.studentToStudentDto(student);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public void createStudent(@RequestBody @Valid StudentCreateDto dto)
      throws ExistingEmailException, MinimumAgeException {
    Student student = StudentCreateDtoMapper.INSTANCE.studentCreateDtoToStudent(dto);
    studentService.create(student);
  }
}
