package com.Blumo.platform_service.controller;

import com.Blumo.platform_service.dto.ApiResponse;
import com.Blumo.platform_service.dto.PlatformCreateRequest;
import com.Blumo.platform_service.dto.PlatformResponse;
import com.Blumo.platform_service.dto.PlatformUpdateRequest;
import com.Blumo.platform_service.service.PlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/platforms")
@RequiredArgsConstructor
public class PlatformController {

    private final PlatformService platformService;

    @PostMapping
    public ResponseEntity<ApiResponse<PlatformResponse>> createPlatform(
            @RequestBody PlatformCreateRequest request) {
        PlatformResponse response = platformService.createPlatform(request);
        return ResponseEntity.ok(ApiResponse.success("Platform created successfully", response));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<PlatformResponse>>> getAllPlatforms() {
        List<PlatformResponse> platforms = platformService.getAllPlatforms();
        return ResponseEntity.ok(ApiResponse.success("All platforms fetched", platforms));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PlatformResponse>> getPlatform(@PathVariable UUID id) {
        PlatformResponse response = platformService.getPlatformById(id);
        return ResponseEntity.ok(ApiResponse.success("Platform fetched successfully", response));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PlatformResponse>> updatePlatform(
            @PathVariable UUID id, @RequestBody PlatformUpdateRequest request) {
        PlatformResponse response = platformService.updatePlatform(id, request);
        return ResponseEntity.ok(ApiResponse.success("Platform updated successfully", response));
    }

    @PatchMapping("/{id}/activate")
    public ResponseEntity<ApiResponse<Void>> activatePlatform(
            @PathVariable UUID id, @RequestParam boolean active) {
        platformService.activatePlatform(id, active);
        return ResponseEntity.ok(ApiResponse.success("Platform status updated successfully", null));
    }
}
