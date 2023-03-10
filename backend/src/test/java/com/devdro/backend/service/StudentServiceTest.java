package com.devdro.backend.service;

import static com.devdro.backend.utils.StudentUtils.getStudent;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.devdro.backend.exeption.ExistingEmailException;
import com.devdro.backend.exeption.StudentNotFoundException;
import com.devdro.backend.model.Student;
import com.devdro.backend.repository.StudentRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

  @Mock
  StudentRepository studentRepository;

  @InjectMocks
  StudentService studentService;

  @Test
  void givenValidStudent_themCreateTheStudent() throws Exception {
    Student student = getStudent(false);
    Student savedStudent = getStudent(true);

    Mockito.when(studentRepository.existsByEmail(student.getEmail()))
        .thenReturn(false);
    Mockito.when(studentRepository.save(student))
        .thenReturn(savedStudent);

    Student result = studentService.create(student);

    assertEquals(savedStudent, result);
  }

  @Test
  void givenStudentWithExistingEmail_themThrowExistingEmailException() {
    Student student = getStudent(false);

    Mockito.when(studentRepository.existsByEmail(student.getEmail()))
        .thenReturn(true);

    assertThrows(ExistingEmailException.class, () -> studentService.create(student));
  }

  @Test
  void givenExistingStudentId_themReturnCorrespondentStudent() throws Exception {
    Student student = getStudent(true);

    Mockito.when(studentRepository.findById(student.getId()))
        .thenReturn(Optional.of(student));

    Student result = studentService.findStudent(student.getId());

    assertEquals(student, result);
  }

  @Test
  void givenNonExistingStudentId_themThrowStudentNotFoundException() throws Exception {
    Long id = 1L;
    Mockito.when(studentRepository.findById(id))
        .thenReturn(Optional.empty());

    assertThrows(StudentNotFoundException.class, () -> studentService.findStudent(id));
  }
}
