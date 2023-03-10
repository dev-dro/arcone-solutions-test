package com.devdro.backend.web.controller;

import static com.devdro.backend.utils.StudentUtils.getStudent;
import static com.devdro.backend.utils.StudentUtils.getStudentDto;

import com.devdro.backend.exeption.ExistingEmailException;
import com.devdro.backend.model.Student;
import com.devdro.backend.service.StudentService;
import com.devdro.backend.web.dto.StudentDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest({StudentController.class, ObjectMapper.class})
class StudentControllerTest {

  static final String API_STUDENT_URL = "/api/students";

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @MockBean
  StudentService studentService;


  @Test
  void givenEmail_whenCallGetStudentByEmail_shouldReturnCorrespondingStudent() throws Exception {
    String email = "example@email.com";
    Student student = getStudent(true);

    Mockito.when(studentService.findStudent(email)).thenReturn(student);

    mockMvc.perform(MockMvcRequestBuilders.get(API_STUDENT_URL + "/" + email))
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  void givenValidStudent_whenCallCreateStudent_shouldReturnCreated() throws Exception {
    StudentDto studentDto = getStudentDto(false);
    Student student = getStudent(true);

    Mockito.when(studentService.create(Mockito.any(Student.class))).thenReturn(student);

    mockMvc.perform(MockMvcRequestBuilders.post(API_STUDENT_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(studentDto)))
        .andExpect(MockMvcResultMatchers.status().isCreated());
  }

  @Test
  void whenCallCreateStudentThrowsExistingEmailException_shouldReturnBadRequest() throws Exception {
    StudentDto studentDto = getStudentDto(false);

    Mockito.when(studentService.create(Mockito.any(Student.class))).thenThrow(ExistingEmailException.class);

    mockMvc.perform(MockMvcRequestBuilders.post(API_STUDENT_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(studentDto)))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
  }
}
