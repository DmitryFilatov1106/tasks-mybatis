package ru.fildv.tasksmybatis.database.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import ru.fildv.tasksmybatis.database.entity.user.Role;
import ru.fildv.tasksmybatis.database.entity.user.User;

import java.util.Optional;

@Mapper
public interface UserRepository {
    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);

    void update(User user);

    void create(User user);

    void insertUserRole(@Param("userId") Long userId,
                        @Param("role") Role role);

    boolean isTaskOwner(@Param("userId") Long userId,
                        @Param("taskId") Long taskId);

    void delete(Long id);
}

