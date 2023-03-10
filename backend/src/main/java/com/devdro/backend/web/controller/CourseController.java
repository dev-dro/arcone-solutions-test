package com.devdro.backend.web.controller;

import com.devdro.backend.exeption.CourseNotFoundException;
import com.devdro.backend.exeption.ExistingCourseException;
import com.devdro.backend.model.Course;
import com.devdro.backend.service.CourseService;
import com.devdro.backend.web.dto.CourseCreateDto;
import com.devdro.backend.web.dto.CourseDto;
import com.devdro.backend.web.mapper.CourseCreateDtoMapper;
import com.devdro.backend.web.mapper.CourseDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

  private final CourseService courseService;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<CourseDto> listCourses() {
    return courseService.listCourses().stream()
        .map(CourseDtoMapper.INSTANCE::courseToCourseDto)
        .collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public CourseDto findCourse(@PathVariable Long id) throws CourseNotFoundException {
    Course course = courseService.findCourse(id);
    return CourseDtoMapper.INSTANCE.courseToCourseDto(course);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void createCourse(@RequestBody @Valid CourseCreateDto dto) throws ExistingCourseException {
    Course course = CourseCreateDtoMapper.INSTANCE.courseCreateDtoToCourse(dto);
    courseService.createCourse(course);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void updateCourse(@PathVariable Long id, @RequestBody CourseCreateDto dto)
      throws CourseNotFoundException, ExistingCourseException {
    Course course = CourseCreateDtoMapper.INSTANCE.courseCreateDtoToCourse(dto);
    courseService.updateCourse(id, course);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteCourse(@PathVariable Long id) {
    courseService.deleteCourse(id);
  }
}
