package com.devdro.backend.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "task_log")
public class TaskLog {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "date", nullable = false)
  private LocalDate date;

  @ManyToOne
  @JoinColumn(name = "enrolled_course_id", nullable = false)
  private EnrolledCourse enrolledCourse;

  @ManyToOne
  @JoinColumn(name = "category_id", nullable = false)
  private TaskCategory category;

  @Column(name = "description", nullable = false)
  private String description;

  @Column(name = "time_spent", nullable = false)
  private Double timeSpent;
}
