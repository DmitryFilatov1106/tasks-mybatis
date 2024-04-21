package ru.fildv.tasksmybatis.http.dto.task;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

@Schema(description = "Task Image DTO")
public record TaskImageDto(
        @NotNull(message = "Image must be not null.")
        MultipartFile file) {
}
