package com.devdro.backend.web.controller;

import com.devdro.backend.exeption.ExistingEmailException;
import com.devdro.backend.exeption.MinimumAgeException;
import com.devdro.backend.exeption.StudentNotFoundException;
import com.devdro.backend.model.Student;
import com.devdro.backend.service.StudentService;
import com.devdro.backend.web.dto.ExceptionDto;
import com.devdro.backend.web.dto.StudentCreateDto;
import com.devdro.backend.web.dto.StudentDto;
import com.devdro.backend.web.mapper.StudentCreateDtoMapper;
import com.devdro.backend.web.mapper.StudentDtoStudentMapper;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

  @ExceptionHandler(MinimumAgeException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionDto handleException(MinimumAgeException e) {
    return new ExceptionDto(e.getMessage());
  }

  @ExceptionHandler(ExistingEmailException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionDto handleException(ExistingEmailException e) {
    return new ExceptionDto(e.getMessage());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionDto handleException(MethodArgumentNotValidException e) {
    return new ExceptionDto(e.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList()));
  }
}
