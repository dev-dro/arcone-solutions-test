package com.devdro.backend.web.mapper;

import com.devdro.backend.model.TaskLog;
import com.devdro.backend.web.dto.TaskLogDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskLogDtoMapper {

  TaskLogDtoMapper INSTANCE = Mappers.getMapper(TaskLogDtoMapper.class);

  TaskLogDto taskLogToTaskLogDto(TaskLog taskLog);
}
