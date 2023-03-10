package com.devdro.backend.repository;

import com.devdro.backend.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

  boolean existsByName(String courseName);
}
