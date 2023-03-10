package com.devdro.backend.web.mapper;

import com.devdro.backend.model.TaskCategory;
import com.devdro.backend.web.dto.TaskCategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskCategoryDtoMapper {

  TaskCategoryDtoMapper INSTANCE = Mappers.getMapper(TaskCategoryDtoMapper.class);

  TaskCategoryDto taskCategoryToTaskCategoryDto(TaskCategory taskCategory);

}
