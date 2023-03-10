package com.devdro.backend.web.controller;

import com.devdro.backend.service.TaskCategoryService;
import com.devdro.backend.web.dto.TaskCategoryDto;
import com.devdro.backend.web.mapper.TaskCategoryDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/task-categories")
@RequiredArgsConstructor
public class TaskCategoryController {

  private final TaskCategoryService taskCategoryService;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<TaskCategoryDto> listTaskCategories() {
    return taskCategoryService.listTaskCategory().stream()
        .map(TaskCategoryDtoMapper.INSTANCE::taskCategoryToTaskCategoryDto)
        .collect(Collectors.toList());
  }
}
