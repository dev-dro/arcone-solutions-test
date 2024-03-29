package com.devdro.backend.service;

import com.devdro.backend.exeption.ExistingEmailException;
import com.devdro.backend.exeption.MinimumAgeException;
import com.devdro.backend.exeption.StudentNotFoundException;
import com.devdro.backend.model.Student;
import com.devdro.backend.repository.StudentRepository;
import java.time.LocalDate;
import java.time.Period;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

  private final StudentRepository studentRepository;

  @Override
  public Student create(Student student) throws ExistingEmailException, MinimumAgeException {
    Integer studentAge = calculateAge(student.getDateOfBirth());
    if (studentAge < 16) {
      throw new MinimumAgeException(studentAge);
    }

    String email = student.getEmail();
    if (studentRepository.existsByEmail(email)) {
      throw new ExistingEmailException(email);
    }

    return studentRepository.save(student);
  }

  @Override
  public Student findStudent(Long id) throws StudentNotFoundException {
    return studentRepository.findById(id)
        .orElseThrow(() -> new StudentNotFoundException(id));
  }

  @Override
  public Student findStudent(String email) throws StudentNotFoundException {
    return studentRepository.findByEmail(email)
        .orElseThrow(() -> new StudentNotFoundException(email));
  }

  private Integer calculateAge(LocalDate dateOfBirth) {
    return Period.between(dateOfBirth, LocalDate.now()).getYears();
  }
}
