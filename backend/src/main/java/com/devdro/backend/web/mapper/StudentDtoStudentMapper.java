package com.devdro.backend.web.mapper;

import com.devdro.backend.model.Student;
import com.devdro.backend.web.dto.StudentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentDtoStudentMapper {

  StudentDtoStudentMapper INSTANCE = Mappers.getMapper(StudentDtoStudentMapper.class);

  Student studentDtoToStudent(StudentDto studentDto);

  StudentDto studentToStudentDto(Student student);
}
