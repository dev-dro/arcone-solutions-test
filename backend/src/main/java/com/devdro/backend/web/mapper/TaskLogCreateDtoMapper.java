package com.devdro.backend.web.mapper;

import com.devdro.backend.model.TaskLog;
import com.devdro.backend.web.dto.TaskLogCreateDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskLogCreateDtoMapper {

  TaskLogCreateDtoMapper INSTANCE = Mappers.getMapper(TaskLogCreateDtoMapper.class);

  TaskLog taskLogCreateDtoToTaskLog(TaskLogCreateDto dto);
}
