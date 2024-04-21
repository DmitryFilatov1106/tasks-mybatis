package ru.fildv.tasksmybatis.http.mapper;

import org.mapstruct.Mapper;
import ru.fildv.tasksmybatis.database.entity.task.Task;
import ru.fildv.tasksmybatis.http.dto.task.TaskDto;

@Mapper(componentModel = "spring")
public interface TaskMapper extends Mappable<Task, TaskDto> {
}
