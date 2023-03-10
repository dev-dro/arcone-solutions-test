package com.devdro.backend.web.mapper;

import static com.devdro.backend.utils.StudentUtils.getStudentCreateDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.devdro.backend.model.Student;
import com.devdro.backend.web.dto.StudentCreateDto;
import org.junit.jupiter.api.Test;

class StudentCreateDtoMapperTest {

  StudentCreateDtoMapper studentCreateDtoMapper = StudentCreateDtoMapper.INSTANCE;

  @Test
  void givenStudentCreateDto_shouldTransformToStudent() {
    StudentCreateDto dto = getStudentCreateDto();
    Student student = studentCreateDtoMapper.studentCreateDtoToStudent(dto);
    assertEquals(dto.getFirstName(), student.getFirstName());
    assertEquals(dto.getLastName(), student.getLastName());
    assertEquals(dto.getDateOfBirth(), student.getDateOfBirth());
    assertEquals(dto.getGender(), student.getGender().toString());
    assertEquals(dto.getEmail(), student.getEmail());
    assertEquals(dto.getPhoneNumber(), student.getPhoneNumber());
    assertEquals(dto.getAddress(), student.getAddress());
  }

  @Test
  void givenStudentCreateDtoWithoutGender_shouldTransformToStudent() {
    StudentCreateDto dto = getStudentCreateDto();
    dto.setGender("");

    Student student = studentCreateDtoMapper.studentCreateDtoToStudent(dto);
    assertEquals(dto.getFirstName(), student.getFirstName());
    assertEquals(dto.getLastName(), student.getLastName());
    assertEquals(dto.getDateOfBirth(), student.getDateOfBirth());
    assertNull(student.getGender());
    assertEquals(dto.getEmail(), student.getEmail());
    assertEquals(dto.getPhoneNumber(), student.getPhoneNumber());
    assertEquals(dto.getAddress(), student.getAddress());
  }
}
