package com.devdro.backend.web.mapper;

import com.devdro.backend.model.EnrolledCourse;
import com.devdro.backend.web.dto.EnrolledCourseCreateDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EnrolledCourseCreateDtoMapper {

  EnrolledCourseCreateDtoMapper INSTANCE = Mappers.getMapper(EnrolledCourseCreateDtoMapper.class);

  EnrolledCourse enrolledCourseCreateDtoToEnrolledCourse(EnrolledCourseCreateDto dto);
}
