package com.devdro.backend.web.controller;

import com.devdro.backend.exeption.CourseFinishedException;
import com.devdro.backend.exeption.EnrolledCourseNotFoundException;
import com.devdro.backend.exeption.TaskLogNotFoundException;
import com.devdro.backend.model.TaskLog;
import com.devdro.backend.service.TaskLogService;
import com.devdro.backend.web.dto.TaskLogCreateDto;
import com.devdro.backend.web.dto.TaskLogDto;
import com.devdro.backend.web.mapper.TaskLogCreateDtoMapper;
import com.devdro.backend.web.mapper.TaskLogDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/task-logs")
@RequiredArgsConstructor
public class TaskLogController {

  private final TaskLogService taskLogService;

  @GetMapping("/enrolled-course/{enrolledCourseId}")
  @ResponseStatus(HttpStatus.OK)
  public List<TaskLogDto> listEnrolledCourseTaskLogs(@PathVariable Long enrolledCourseId) {
    return taskLogService.listTaskLogsByEnrolledCourse(enrolledCourseId).stream()
        .map(TaskLogDtoMapper.INSTANCE::taskLogToTaskLogDto)
        .collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public TaskLogDto findTaskLog(@PathVariable Long id) throws TaskLogNotFoundException {
    TaskLog taskLog = taskLogService.findTaskLog(id);
    return TaskLogDtoMapper.INSTANCE.taskLogToTaskLogDto(taskLog);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void createTaskLog(@RequestBody @Valid TaskLogCreateDto dto)
      throws CourseFinishedException, EnrolledCourseNotFoundException {
    TaskLog taskLog = TaskLogCreateDtoMapper.INSTANCE.taskLogCreateDtoToTaskLog(dto);
    taskLogService.createTaskLog(taskLog);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void createTaskLog(@PathVariable Long id, @RequestBody TaskLogCreateDto dto)
      throws CourseFinishedException, EnrolledCourseNotFoundException, TaskLogNotFoundException {
    TaskLog taskLog = TaskLogCreateDtoMapper.INSTANCE.taskLogCreateDtoToTaskLog(dto);
    taskLogService.updateTaskLog(id, taskLog);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteCourse(@PathVariable Long id) {
    taskLogService.deleteTaskLog(id);
  }
}
