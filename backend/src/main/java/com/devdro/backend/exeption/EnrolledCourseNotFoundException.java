package com.devdro.backend.exeption;

public class EnrolledCourseNotFoundException extends EntityNotFoundException {

  public EnrolledCourseNotFoundException(Long id) {
    super("Enrolled Course", id);
  }
}
