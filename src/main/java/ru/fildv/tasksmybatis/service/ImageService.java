package ru.fildv.tasksmybatis.service;

import ru.fildv.tasksmybatis.database.entity.task.TaskImage;

public interface ImageService {
    String upload(TaskImage image);
}
