package com.devdro.backend.service;

import com.devdro.backend.exeption.CourseFinishedException;
import com.devdro.backend.exeption.EnrolledCourseNotFoundException;
import com.devdro.backend.exeption.TaskLogNotFoundException;
import com.devdro.backend.model.CourseStatus;
import com.devdro.backend.model.EnrolledCourse;
import com.devdro.backend.model.TaskLog;
import com.devdro.backend.repository.TaskLogRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskLogServiceImpl implements TaskLogService {

  private final TaskLogRepository taskLogRepository;
  private final EnrolledCourseService enrolledCourseService;

  @Override
  public List<TaskLog> listTaskLogsByEnrolledCourse(Long enrolledCourseId) {
    return taskLogRepository.findAllByEnrolledCourseId(enrolledCourseId);
  }

  @Override
  public TaskLog findTaskLog(Long id) throws TaskLogNotFoundException {
    return taskLogRepository.findById(id)
        .orElseThrow(() -> new TaskLogNotFoundException(id));
  }

  @Override
  public void createTaskLog(TaskLog taskLog) throws CourseFinishedException, EnrolledCourseNotFoundException {
    EnrolledCourse enrolledCourse = enrolledCourseService.findEnrolledCourse(taskLog.getEnrolledCourse().getId());
    if (enrolledCourse.getStatus() != CourseStatus.ENROLLED) {
      throw new CourseFinishedException();
    }

    taskLogRepository.save(taskLog);
    enrolledCourseService.checkIfCompleted(taskLog.getEnrolledCourse().getId());
  }

  @Override
  public void updateTaskLog(Long id, TaskLog taskLog)
      throws TaskLogNotFoundException, CourseFinishedException, EnrolledCourseNotFoundException {
    TaskLog existingTaskLog = findTaskLog(id);

    EnrolledCourse enrolledCourse = enrolledCourseService.findEnrolledCourse(taskLog.getEnrolledCourse().getId());
    if (enrolledCourse.getStatus() != CourseStatus.ENROLLED) {
      throw new CourseFinishedException();
    }

    existingTaskLog.setCategory(taskLog.getCategory());
    existingTaskLog.setTimeSpent(taskLog.getTimeSpent());

    taskLogRepository.save(taskLog);
    enrolledCourseService.checkIfCompleted(taskLog.getEnrolledCourse().getId());
  }

  @Override
  public void deleteTaskLog(Long id) {
    taskLogRepository.deleteById(id);
  }
}
