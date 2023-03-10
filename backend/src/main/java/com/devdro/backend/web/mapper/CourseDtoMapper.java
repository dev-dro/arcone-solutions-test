package com.devdro.backend.web.mapper;

import com.devdro.backend.model.Course;
import com.devdro.backend.web.dto.CourseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseDtoMapper {

  CourseDtoMapper INSTANCE = Mappers.getMapper(CourseDtoMapper.class);

  CourseDto courseToCourseDto(Course course);
}
