package com.devdro.backend.web.mapper;

import com.devdro.backend.model.Gender;
import com.devdro.backend.model.Student;
import com.devdro.backend.web.dto.StudentCreateDto;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentCreateDtoMapper {

  StudentCreateDtoMapper INSTANCE = Mappers.getMapper(StudentCreateDtoMapper.class);

  @Mappings({
      @Mapping(target = "id", ignore = true),
      @Mapping(source = "gender", target = "gender", qualifiedByName = "genderStringToEnum")
  })
  Student studentCreateDtoToStudent(StudentCreateDto studentCreateDto);

  @Named("genderStringToEnum")
  static Gender genderStringToEnum(String gender) {
    return StringUtils.isNotBlank(gender) ? Gender.valueOf(gender) : null;
  }
}
