package com.devdro.backend.web.mapper;

import com.devdro.backend.model.EnrolledCourse;
import com.devdro.backend.web.dto.EnrolledCourseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EnrolledCourseDtoMapper {

  EnrolledCourseDtoMapper INSTANCE = Mappers.getMapper(EnrolledCourseDtoMapper.class);

  EnrolledCourseDto enrolledCourseToEnrolledCourseDto(EnrolledCourse enrolledCourse);
}
