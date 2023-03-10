package com.devdro.backend.repository;

import com.devdro.backend.model.EnrolledCourse;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrolledCourseRepository extends JpaRepository<EnrolledCourse, Long> {

  List<EnrolledCourse> findAllByStudentId(Long studentId);

  Integer countAllByStudentId(Long studentId);
}
