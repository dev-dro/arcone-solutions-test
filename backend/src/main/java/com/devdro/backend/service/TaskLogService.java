package com.devdro.backend.service;

import com.devdro.backend.exeption.CourseFinishedException;
import com.devdro.backend.exeption.EnrolledCourseNotFoundException;
import com.devdro.backend.exeption.TaskLogNotFoundException;
import com.devdro.backend.model.TaskLog;
import java.util.List;

public interface TaskLogService {

  List<TaskLog> listTaskLogsByEnrolledCourse(Long enrolledCourseId);

  TaskLog findTaskLog(Long id) throws TaskLogNotFoundException;

  void createTaskLog(TaskLog taskLog) throws CourseFinishedException, EnrolledCourseNotFoundException;

  void updateTaskLog(Long id, TaskLog taskLog)
      throws TaskLogNotFoundException, CourseFinishedException, EnrolledCourseNotFoundException;

  void deleteTaskLog(Long id);
}
