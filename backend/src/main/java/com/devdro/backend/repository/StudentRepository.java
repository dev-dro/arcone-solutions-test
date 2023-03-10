package com.devdro.backend.repository;

import com.devdro.backend.model.Student;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  boolean existsByEmail(String email);

  Optional<Student> findByEmail(String email);
}
