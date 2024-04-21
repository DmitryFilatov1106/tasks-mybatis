package ru.fildv.tasksmybatis.http.rest;

/*
  Для @PreAuthorize использовал CustomSecurityExpression
 */

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fildv.tasksmybatis.database.entity.task.Task;
import ru.fildv.tasksmybatis.database.entity.user.User;
import ru.fildv.tasksmybatis.http.dto.task.TaskDto;
import ru.fildv.tasksmybatis.http.dto.user.UserDto;
import ru.fildv.tasksmybatis.http.mapper.TaskMapper;
import ru.fildv.tasksmybatis.http.mapper.UserMapper;
import ru.fildv.tasksmybatis.http.validation.group.CreateAction;
import ru.fildv.tasksmybatis.http.validation.group.UpdateAction;
import ru.fildv.tasksmybatis.service.TaskService;
import ru.fildv.tasksmybatis.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/v1/users")
@Tag(name = "User Controller", description = "User API")
public class UserController {
    private final UserService userService;
    private final TaskService taskService;

    private final UserMapper userMapper;
    private final TaskMapper taskMapper;

    @GetMapping("/{id}")
    @Operation(summary = "Get userDto by id")
    @PreAuthorize("@customSecurityExpression.canAccessUser(#id)")
    public UserDto getById(final @PathVariable Long id) {
        User user = userService.getById(id);
        return userMapper.toDto(user);
    }

    @PutMapping
    @Operation(summary = "Update user")
    @PreAuthorize("@customSecurityExpression.canAccessUser(#dto.id)")
    public UserDto update(final @Validated(UpdateAction.class)
                              @RequestBody UserDto dto) {
        User user = userMapper.toEntity(dto);
        User updatedUser = userService.update(user);
        return userMapper.toDto(updatedUser);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user by id")
    @PreAuthorize("@customSecurityExpression.canAccessUser(#id)")
    public void deleteById(final @PathVariable Long id) {
        userService.delete(id);
    }

    @GetMapping("/{id}/tasks")
    @Operation(summary = "Get all user tasks")
    @PreAuthorize("@customSecurityExpression.canAccessUser(#id)")
    public List<TaskDto> getTasksByUserId(final @PathVariable Long id) {
        List<Task> taskList = taskService.getAllByUserId(id);
        return taskMapper.toDto(taskList);
    }

    @PostMapping("/{id}/tasks")
    @Operation(summary = "Add task to user")
    @PreAuthorize("@customSecurityExpression.canAccessUser(#id)")
    public TaskDto createTask(final @PathVariable Long id,
                              final @Validated(CreateAction.class)
                              @RequestBody TaskDto dto) {
        Task task = taskMapper.toEntity(dto);
        Task createdTask = taskService.create(task, id);
        return taskMapper.toDto(createdTask);
    }
}
