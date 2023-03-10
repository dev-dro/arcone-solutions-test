package com.devdro.backend.service;

import com.devdro.backend.model.TaskCategory;
import com.devdro.backend.repository.TaskCategoryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskCategoryServiceImpl implements TaskCategoryService {

  private final TaskCategoryRepository taskCategoryRepository;

  @Override
  public List<TaskCategory> listTaskCategory() {
    return taskCategoryRepository.findAll();
  }
}
