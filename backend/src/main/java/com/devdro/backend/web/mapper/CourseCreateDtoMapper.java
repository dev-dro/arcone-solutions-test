package com.devdro.backend.web.mapper;

import com.devdro.backend.model.Course;
import com.devdro.backend.web.dto.CourseCreateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseCreateDtoMapper {

  CourseCreateDtoMapper INSTANCE = Mappers.getMapper(CourseCreateDtoMapper.class);

  @Mappings({
      @Mapping(target = "id", ignore = true),
      @Mapping(target = "endDate", ignore = true)
  })
  Course courseCreateDtoToCourse(CourseCreateDto dto);
}
