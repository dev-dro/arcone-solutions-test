package com.devdro.backend.service;

import com.devdro.backend.exeption.CourseFinishedException;
import com.devdro.backend.exeption.CourseNotFoundException;
import com.devdro.backend.exeption.EnrolledCourseNotFoundException;
import com.devdro.backend.exeption.EnrolledCoursesLimitException;
import com.devdro.backend.model.CourseStatus;
import com.devdro.backend.model.EnrolledCourse;
import java.util.List;

public interface EnrolledCourseService {

  List<EnrolledCourse> listStudentEnrolledCourse(Long studentId);

  EnrolledCourse findEnrolledCourse(Long id) throws EnrolledCourseNotFoundException;

  void createEnrolledCourse(EnrolledCourse enrolledCourse)
      throws CourseNotFoundException, CourseFinishedException, EnrolledCoursesLimitException;

  void updateEnrolledCourseStatus(Long id, CourseStatus courseStatus) throws EnrolledCourseNotFoundException;

  void deleteEnrolledCourse(Long id) throws EnrolledCourseNotFoundException;

  void checkIfCompleted(Long id) throws EnrolledCourseNotFoundException;
}
