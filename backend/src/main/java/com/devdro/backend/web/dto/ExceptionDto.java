package com.devdro.backend.web.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class ExceptionDto {

  private List<String> messages = new ArrayList<>();

  public ExceptionDto(String message) {
    addMessage(message);
  }

  public ExceptionDto(List<String> messages) {
    this.messages.addAll(messages);
  }

  public void addMessage(String message) {
    this.messages.add(message);
  }
}
