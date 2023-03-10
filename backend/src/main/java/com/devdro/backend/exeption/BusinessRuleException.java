package com.devdro.backend.exeption;

public abstract class BusinessRuleException extends Exception {

  public BusinessRuleException(String message) {
    super(message);
  }
}
