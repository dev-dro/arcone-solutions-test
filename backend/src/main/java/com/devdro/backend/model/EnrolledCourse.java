package com.devdro.backend.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "enrolled_course")
public class EnrolledCourse {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "student_id", nullable = false)
  private Student student;

  @ManyToOne
  @JoinColumn(name = "course_id", nullable = false)
  private Course course;

  @OneToMany(mappedBy = "enrolledCourse")
  private List<TaskLog> taskLogs;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false)
  private CourseStatus status;

  public Double getTotalTimeSpent() {
    Double counter = 0.0;
    if (!CollectionUtils.isEmpty(taskLogs)) {
      counter = taskLogs.stream()
          .map(TaskLog::getTimeSpent)
          .reduce(Double::sum)
          .orElse(0.0);
    }
    return counter;
  }
}
