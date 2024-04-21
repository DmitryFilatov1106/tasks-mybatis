package ru.fildv.tasksmybatis.http.mapper;

import org.mapstruct.Mapper;
import ru.fildv.tasksmybatis.database.entity.task.TaskImage;
import ru.fildv.tasksmybatis.http.dto.task.TaskImageDto;

@Mapper(componentModel = "spring")
public interface TaskImageMapper extends Mappable<TaskImage, TaskImageDto> {
}
