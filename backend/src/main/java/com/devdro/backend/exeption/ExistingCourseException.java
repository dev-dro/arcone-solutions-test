package com.devdro.backend.exeption;

public class ExistingCourseException extends BusinessRuleException {

  public ExistingCourseException(String name) {
    super("The course " + name + " already exists.");
  }
}
