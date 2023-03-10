package com.devdro.backend.exeption;

public class CourseFinishedException extends BusinessRuleException {

  public CourseFinishedException() {
    super("This course already finished");
  }
}
