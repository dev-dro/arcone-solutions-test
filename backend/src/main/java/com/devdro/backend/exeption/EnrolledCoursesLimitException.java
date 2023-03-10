package com.devdro.backend.exeption;

public class EnrolledCoursesLimitException extends BusinessRuleException {

  public EnrolledCoursesLimitException(Integer limit) {
    super("The student is already enrolled in " + limit + " courses");
  }
}
