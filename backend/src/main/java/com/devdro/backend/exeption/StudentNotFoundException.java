package com.devdro.backend.exeption;

public class StudentNotFoundException extends EntityNotFoundException {

  public StudentNotFoundException(Long id) {
    super("Student", id);
  }

  public StudentNotFoundException(String email) {
    super("Could not found Student with email " + email);
  }
}
