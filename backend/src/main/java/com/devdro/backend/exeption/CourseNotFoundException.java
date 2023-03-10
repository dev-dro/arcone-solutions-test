package com.devdro.backend.exeption;

public class CourseNotFoundException extends EntityNotFoundException {

  public CourseNotFoundException(Long id) {
    super("Course", id);
  }
}
