package com.Blumo.platform_service.service;


import com.Blumo.platform_service.Repository.PlatformRepository;
import com.Blumo.platform_service.dto.PlatformCreateRequest;
import com.Blumo.platform_service.dto.PlatformResponse;
import com.Blumo.platform_service.dto.PlatformUpdateRequest;
import com.Blumo.platform_service.exception.DuplicateResourceException;
import com.Blumo.platform_service.exception.ResourceNotFoundException;
import com.Blumo.platform_service.mapper.PlatformMapper;
import com.Blumo.platform_service.model.Platform;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlatformServiceImpl implements PlatformService {
    @Autowired
    private  PlatformRepository platformRepository;

    @Override
    public PlatformResponse createPlatform(PlatformCreateRequest request) {

        if (platformRepository.existsByName(request.getName())) {
            throw new DuplicateResourceException("Platform with this name already exists");
        }

        Platform platform = PlatformMapper.toEntity(request);
        return PlatformMapper.toResponse(platformRepository.save(platform));
    }

    @Override
    public List<PlatformResponse> getAllPlatforms() {
        return platformRepository.findAll()
                .stream()
                .map(PlatformMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PlatformResponse getPlatformById(UUID id) {
        Platform platform = platformRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Platform not found"));
        return PlatformMapper.toResponse(platform);
    }

    @Override
    public PlatformResponse updatePlatform(UUID id, PlatformUpdateRequest request) {
        Platform platform = platformRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Platform not found"));

        PlatformMapper.updateEntity(platform, request);
        platform.setUpdatedAt(Instant.now());

        return PlatformMapper.toResponse(platformRepository.save(platform));
    }

    @Override
    public void activatePlatform(UUID id, boolean active) {
        Platform platform = platformRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Platform not found"));
        platform.setIsActive(active);
        platform.setUpdatedAt(Instant.now());
        platformRepository.save(platform);
    }
}
