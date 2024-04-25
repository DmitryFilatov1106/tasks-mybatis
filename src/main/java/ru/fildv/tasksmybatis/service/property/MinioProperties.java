package ru.fildv.tasksmybatis.service.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "minio")
public class MinioProperties {
    private String bucket;
    private String url;
    private String accessKey;
    private String secretKey;
}
