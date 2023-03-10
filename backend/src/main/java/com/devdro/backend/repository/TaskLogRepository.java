package com.devdro.backend.repository;

import com.devdro.backend.model.TaskLog;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskLogRepository extends JpaRepository<TaskLog, Long> {

  List<TaskLog> findAllByEnrolledCourseId(Long enrolledCourseId);
}
