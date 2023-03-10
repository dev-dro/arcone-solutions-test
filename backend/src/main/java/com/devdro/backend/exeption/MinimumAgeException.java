package com.devdro.backend.exeption;

public class MinimumAgeException extends BusinessRuleException {

  public MinimumAgeException(Integer age) {
    super("The minimum age for students is 16");
  }
}
