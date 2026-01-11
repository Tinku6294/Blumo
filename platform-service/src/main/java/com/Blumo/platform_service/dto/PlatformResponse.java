package com.Blumo.platform_service.dto;

import lombok.Data;
import java.time.Instant;
import java.util.UUID;

@Data
public class PlatformResponse {

    private UUID id;
    private String name;
    private Boolean isActive;
    private Integer priorityScore;
    private Instant createdAt;
    private Instant updatedAt;
}
