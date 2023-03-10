package com.devdro.backend.service;

import com.devdro.backend.exeption.CourseFinishedException;
import com.devdro.backend.exeption.CourseNotFoundException;
import com.devdro.backend.exeption.EnrolledCourseNotFoundException;
import com.devdro.backend.exeption.EnrolledCoursesLimitException;
import com.devdro.backend.model.CourseStatus;
import com.devdro.backend.model.EnrolledCourse;
import com.devdro.backend.repository.EnrolledCourseRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@RequiredArgsConstructor
public class EnrolledCourseServiceImpl implements EnrolledCourseService {

  private static final Integer LIMIT_ENROLLED_COURSES = 3;

  private final EnrolledCourseRepository enrolledCourseRepository;
  private final CourseService courseService;

  @Override
  public List<EnrolledCourse> listStudentEnrolledCourse(Long studentId) {
    return enrolledCourseRepository.findAllByStudentId(studentId);
  }

  @Override
  public EnrolledCourse findEnrolledCourse(Long id) throws EnrolledCourseNotFoundException {
    return enrolledCourseRepository.findById(id)
        .orElseThrow(() -> new EnrolledCourseNotFoundException(id));
  }

  @Override
  public void createEnrolledCourse(EnrolledCourse enrolledCourse)
      throws CourseNotFoundException, CourseFinishedException, EnrolledCoursesLimitException {
    if (courseService.isCourseFinished(enrolledCourse.getCourse().getId())) {
      throw new CourseFinishedException();
    }

    if (enrolledCourseRepository.countAllByStudentId(enrolledCourse.getStudent().getId()) >= LIMIT_ENROLLED_COURSES) {
      throw new EnrolledCoursesLimitException(LIMIT_ENROLLED_COURSES);
    }

    enrolledCourseRepository.save(enrolledCourse);
  }

  @Override
  public void updateEnrolledCourseStatus(Long id, CourseStatus courseStatus) throws EnrolledCourseNotFoundException {
    EnrolledCourse existingEnrolledCourse = findEnrolledCourse(id);
    existingEnrolledCourse.setStatus(courseStatus);
    enrolledCourseRepository.save(existingEnrolledCourse);
  }

  @Override
  public void deleteEnrolledCourse(Long id) throws EnrolledCourseNotFoundException {
    EnrolledCourse enrolledCourse = findEnrolledCourse(id);
    if (!CollectionUtils.isEmpty(enrolledCourse.getTaskLogs())) {
      enrolledCourse.setStatus(CourseStatus.CANCELED);
      enrolledCourseRepository.save(enrolledCourse);
    } else {
      enrolledCourseRepository.deleteById(id);
    }
  }

  @Override
  public void checkIfCompleted(Long id) throws EnrolledCourseNotFoundException {
    EnrolledCourse enrolledCourse = findEnrolledCourse(id);
    Double totalTimeSpent = enrolledCourse.getTotalTimeSpent();
    if (totalTimeSpent >= enrolledCourse.getCourse().getDuration()) {
      updateEnrolledCourseStatus(enrolledCourse.getId(), CourseStatus.COMPLETED);
    }
  }
}
