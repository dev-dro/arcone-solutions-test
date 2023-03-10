package com.devdro.backend.exeption;

public abstract class EntityNotFoundException extends Exception {

  public EntityNotFoundException(String entity, Long id) {
    super("Could not found " + entity + " with id " + id);
  }

  public EntityNotFoundException(String message) {
    super(message);
  }
}
