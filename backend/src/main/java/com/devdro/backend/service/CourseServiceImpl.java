package com.devdro.backend.service;

import com.devdro.backend.exeption.CourseNotFoundException;
import com.devdro.backend.exeption.ExistingCourseException;
import com.devdro.backend.model.Course;
import com.devdro.backend.repository.CourseRepository;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

  public static final int MONTHS_TO_COMPLETE = 6;
  private final CourseRepository courseRepository;

  @Override
  public List<Course> listCourses() {
    return courseRepository.findAll();
  }

  @Override
  public Course findCourse(Long id) throws CourseNotFoundException {
    return courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
  }

  @Override
  public void createCourse(Course course) throws ExistingCourseException {
    String courseName = course.getName();
    if (courseRepository.existsByName(courseName)) {
      throw new ExistingCourseException(courseName);
    }

    course.setEndDate(course.getStartDate().plusMonths(MONTHS_TO_COMPLETE));

    courseRepository.save(course);
  }

  @Override
  public void updateCourse(Long id, Course course) throws CourseNotFoundException, ExistingCourseException {
    Course existingCourse = findCourse(id);
    String courseName = course.getName();
    if (courseRepository.existsByNameAndIdNot(courseName, id)) {
      throw new ExistingCourseException(courseName);
    }
    existingCourse.setName(course.getName());
    existingCourse.setDuration(course.getDuration());
    existingCourse.setStartDate(course.getStartDate());

    courseRepository.save(existingCourse);
  }

  @Override
  public void deleteCourse(Long id) {
    courseRepository.deleteById(id);
  }

  @Override
  public boolean isCourseFinished(Long id) throws CourseNotFoundException {
    Course course = findCourse(id);
    return course.getEndDate().isBefore(LocalDate.now());
  }
}
