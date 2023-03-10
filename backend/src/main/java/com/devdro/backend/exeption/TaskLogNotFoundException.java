package com.devdro.backend.exeption;

public class TaskLogNotFoundException extends EntityNotFoundException {

  public TaskLogNotFoundException(Long id) {
    super("Task Log", id);
  }
}
