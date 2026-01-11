package com.Blumo.platform_service.service;
import com.Blumo.platform_service.dto.PlatformCreateRequest;
import com.Blumo.platform_service.dto.PlatformResponse;
import com.Blumo.platform_service.dto.PlatformUpdateRequest;

import java.util.List;
import java.util.UUID;

public interface PlatformService {


    PlatformResponse createPlatform(PlatformCreateRequest request);

    List<PlatformResponse> getAllPlatforms();

    PlatformResponse getPlatformById(UUID id);

    PlatformResponse updatePlatform(UUID id, PlatformUpdateRequest request);

    void activatePlatform(UUID id, boolean active);
}
