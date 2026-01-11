package com.Blumo.platform_service.mapper;



import com.Blumo.platform_service.dto.PlatformCreateRequest;
import com.Blumo.platform_service.dto.PlatformResponse;
import com.Blumo.platform_service.dto.PlatformUpdateRequest;
import com.Blumo.platform_service.model.Platform;

import java.time.Instant;

public class PlatformMapper {

    public static Platform toEntity(PlatformCreateRequest dto) {
        Platform p = new Platform();
        p.setName(dto.getName());
        p.setPriorityScore(dto.getPriorityScore());
        p.setIsActive(true);
        p.setCreatedAt(Instant.now());
        p.setUpdatedAt(Instant.now());
        return p;
    }

    public static void updateEntity(Platform platform, PlatformUpdateRequest dto) {
        platform.setName(dto.getName());
        platform.setPriorityScore(dto.getPriorityScore());
        platform.setUpdatedAt(Instant.now());
    }

    public static PlatformResponse toResponse(Platform entity) {
        PlatformResponse dto = new PlatformResponse();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setIsActive(entity.getIsActive());
        dto.setPriorityScore(entity.getPriorityScore());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }
}
