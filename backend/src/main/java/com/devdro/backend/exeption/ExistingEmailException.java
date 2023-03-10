package com.devdro.backend.exeption;

public class ExistingEmailException extends Exception {

  public ExistingEmailException(String email) {
    super("The email " + email + " is already in use.");
  }
}
