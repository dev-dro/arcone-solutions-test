package com.devdro.backend.service;

import com.devdro.backend.exeption.CourseNotFoundException;
import com.devdro.backend.exeption.ExistingCourseException;
import com.devdro.backend.model.Course;
import java.util.List;

public interface CourseService {

  List<Course> listCourses();

  Course findCourse(Long id) throws CourseNotFoundException;

  void createCourse(Course course) throws ExistingCourseException;

  void updateCourse(Long id, Course course) throws CourseNotFoundException;

  void deleteCourse(Long id);
}
