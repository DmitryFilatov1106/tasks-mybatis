package ru.fildv.tasksmybatis.database.entity.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task implements Serializable {
    private Long id;
    private String title;
    private String description;
    private Status status;
    private LocalDateTime expirationDate;
    private List<TaskImage> images;
}
