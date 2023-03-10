package com.devdro.backend.exeption;

public class ExistingEmailException extends BusinessRuleException {

  public ExistingEmailException(String email) {
    super("The email " + email + " is already in use.");
  }
}
