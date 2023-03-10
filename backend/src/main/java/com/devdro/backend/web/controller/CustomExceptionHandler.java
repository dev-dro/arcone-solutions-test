package com.devdro.backend.web.controller;

import com.devdro.backend.exeption.BusinessRuleException;
import com.devdro.backend.exeption.EntityNotFoundException;
import com.devdro.backend.web.dto.ExceptionDto;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionDto handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
    return new ExceptionDto(e.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList()));
  }

  @ExceptionHandler(BusinessRuleException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionDto handleBusinessRulesException(BusinessRuleException e) {
    return new ExceptionDto(e.getMessage());
  }

  @ExceptionHandler(EntityNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ExceptionDto handleEntityNotFoundException(EntityNotFoundException e) {
    return new ExceptionDto(e.getMessage());
  }
}
