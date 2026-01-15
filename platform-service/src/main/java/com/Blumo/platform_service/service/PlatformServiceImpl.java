package com.Blumo.platform_service.service;

import com.Blumo.platform_service.Repository.PlatformRepository;
import com.Blumo.platform_service.dto.PlatformCreateRequest;
import com.Blumo.platform_service.dto.PlatformResponse;
import com.Blumo.platform_service.dto.PlatformUpdateRequest;
import com.Blumo.platform_service.exception.BadRequestException;
import com.Blumo.platform_service.exception.DuplicateResourceException;
import com.Blumo.platform_service.exception.ResourceNotFoundException;
import com.Blumo.platform_service.mapper.PlatformMapper;
import com.Blumo.platform_service.model.Platform;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlatformServiceImpl implements PlatformService {

    private final PlatformRepository platformRepository;

    /* ================= CREATE ================= */
    @Override
    public PlatformResponse createPlatform(PlatformCreateRequest request) {
        validateCreateRequest(request);

        // Duplicate check
        if (platformRepository.existsByNameIgnoreCase(request.getName())) {
            throw new DuplicateResourceException(
                    "Platform with name '" + request.getName() + "' already exists"
            );
        }

        Platform platform = PlatformMapper.toEntity(request);
        Platform saved = platformRepository.save(platform);
        return PlatformMapper.toResponse(saved);
    }

    /* ================= UPDATE ================= */
    @Override
    public PlatformResponse updatePlatform(UUID id, PlatformUpdateRequest request) {
        if (id == null) throw new BadRequestException("Platform ID must not be null");
        if (request == null) throw new BadRequestException("Request body must not be null");

        Platform platform = platformRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Platform not found"));

        // Update only provided fields
        PlatformMapper.updateEntity(platform, request);

        // Validate after update
        validateUpdateRequest(platform);

        platform.setUpdatedAt(Instant.now());
        Platform updated = platformRepository.save(platform);

        return PlatformMapper.toResponse(updated);
    }

    /* ================= GET BY ID ================= */
    @Override
    public PlatformResponse getPlatformById(UUID id) {
        if (id == null) throw new BadRequestException("Platform ID must not be null");

        Platform platform = platformRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Platform not found"));

        return PlatformMapper.toResponse(platform);
    }

    /* ================= GET ALL ================= */
    @Override
    public List<PlatformResponse> getAllPlatforms() {
        List<Platform> platforms = platformRepository.findAll();
        if (platforms.isEmpty())
            throw new ResourceNotFoundException("No platforms found in the database");

        return platforms.stream()
                .map(PlatformMapper::toResponse)
                .collect(Collectors.toList());
    }

    /* ================= ACTIVATE / DEACTIVATE ================= */
    @Override
    public void activatePlatform(UUID id, boolean active) {
        if (id == null) throw new BadRequestException("Platform ID must not be null");

        Platform platform = platformRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Platform not found"));

        platform.setIsActive(active);
        platform.setUpdatedAt(Instant.now());
        platformRepository.save(platform);
    }

    /* ================= VALIDATIONS ================= */
    private void validateCreateRequest(PlatformCreateRequest request) {
        if (request == null) throw new BadRequestException("Request body must not be null");
        if (!StringUtils.hasText(request.getName())) throw new BadRequestException("Platform name is required");
        if (request.getPriorityScore() == null) throw new BadRequestException("Priority score is required");
    }

    private void validateUpdateRequest(Platform platform) {
        if (!StringUtils.hasText(platform.getName())) throw new BadRequestException("Platform name cannot be null or empty");
        if (platform.getPriorityScore() == null) throw new BadRequestException("Priority score cannot be null");
        if (platform.getIsActive() == null) throw new BadRequestException("Platform active status cannot be null");
    }
}
