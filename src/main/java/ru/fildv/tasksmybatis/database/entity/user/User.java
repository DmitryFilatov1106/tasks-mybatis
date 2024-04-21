package ru.fildv.tasksmybatis.database.entity.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.fildv.tasksmybatis.database.entity.task.Task;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {
    private Long id;
    private String name;
    private String username;
    private String password;
    private String passwordConfirm;
    private Set<Role> roles;
    private List<Task> tasks;
}
