package com.devdro.backend.web.controller;

import com.devdro.backend.exeption.CourseFinishedException;
import com.devdro.backend.exeption.CourseNotFoundException;
import com.devdro.backend.exeption.EnrolledCourseNotFoundException;
import com.devdro.backend.exeption.EnrolledCoursesLimitException;
import com.devdro.backend.model.EnrolledCourse;
import com.devdro.backend.service.EnrolledCourseService;
import com.devdro.backend.web.dto.EnrolledCourseCreateDto;
import com.devdro.backend.web.dto.EnrolledCourseDto;
import com.devdro.backend.web.mapper.EnrolledCourseCreateDtoMapper;
import com.devdro.backend.web.mapper.EnrolledCourseDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/enrolled-courses")
@RequiredArgsConstructor
public class EnrolledCourseController {

  private final EnrolledCourseService enrolledCourseService;

  @GetMapping("/student/{studentId}")
  @ResponseStatus(HttpStatus.OK)
  public List<EnrolledCourseDto> listStudentEnrolledCourses(@PathVariable Long studentId) {
    return enrolledCourseService.listStudentEnrolledCourse(studentId).stream()
        .map(EnrolledCourseDtoMapper.INSTANCE::enrolledCourseToEnrolledCourseDto)
        .collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public EnrolledCourseDto findEnrolledCourse(@PathVariable Long id) throws EnrolledCourseNotFoundException {
    EnrolledCourse enrolledCourse = enrolledCourseService.findEnrolledCourse(id);
    return EnrolledCourseDtoMapper.INSTANCE.enrolledCourseToEnrolledCourseDto(enrolledCourse);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void createEnrolledCourse(@RequestBody @Valid EnrolledCourseCreateDto dto)
      throws CourseFinishedException, CourseNotFoundException, EnrolledCoursesLimitException {
    EnrolledCourse enrolledCourse = EnrolledCourseCreateDtoMapper.INSTANCE.enrolledCourseCreateDtoToEnrolledCourse(dto);
    enrolledCourseService.createEnrolledCourse(enrolledCourse);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteCourse(@PathVariable Long id) throws EnrolledCourseNotFoundException {
    enrolledCourseService.deleteEnrolledCourse(id);
  }
}
