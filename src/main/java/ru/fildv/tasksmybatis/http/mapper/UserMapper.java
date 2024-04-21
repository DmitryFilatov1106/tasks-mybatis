package ru.fildv.tasksmybatis.http.mapper;

import org.mapstruct.Mapper;
import ru.fildv.tasksmybatis.database.entity.user.User;
import ru.fildv.tasksmybatis.http.dto.user.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper extends Mappable<User, UserDto> {
}
