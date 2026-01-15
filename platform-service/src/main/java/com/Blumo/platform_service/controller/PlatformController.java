package com.Blumo.platform_service.controller;

import com.Blumo.platform_service.dto.ApiResponse;
import com.Blumo.platform_service.dto.PlatformCreateRequest;
import com.Blumo.platform_service.dto.PlatformResponse;
import com.Blumo.platform_service.dto.PlatformUpdateRequest;
import com.Blumo.platform_service.service.PlatformService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/platforms")
@RequiredArgsConstructor
public class PlatformController {

    private final PlatformService platformService;

    /* ================= CREATE PLATFORM ================= */
    @PostMapping
    public ResponseEntity<ApiResponse<PlatformResponse>> createPlatform(
            @Valid @RequestBody PlatformCreateRequest request) {

        PlatformResponse response = platformService.createPlatform(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Platform created successfully", response));
    }

    /* ================= UPDATE PLATFORM ================= */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PlatformResponse>> updatePlatform(
            @PathVariable("id") UUID id,
            @Valid @RequestBody PlatformUpdateRequest request) {

        PlatformResponse response = platformService.updatePlatform(id, request);
        return ResponseEntity.ok(ApiResponse.success("Platform updated successfully", response));
    }

    /* ================= GET PLATFORM BY ID ================= */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PlatformResponse>> getPlatformById(@PathVariable("id") UUID id) {
        PlatformResponse response = platformService.getPlatformById(id);
        return ResponseEntity.ok(ApiResponse.success("Platform retrieved successfully", response));
    }

    /* ================= GET ALL PLATFORMS ================= */
    @GetMapping
    public ResponseEntity<ApiResponse<List<PlatformResponse>>> getAllPlatforms() {
        List<PlatformResponse> response = platformService.getAllPlatforms();
        return ResponseEntity.ok(ApiResponse.success("Platforms retrieved successfully", response));
    }

    /* ================= ACTIVATE / DEACTIVATE PLATFORM ================= */
    @PatchMapping("/{id}/activate")
    public ResponseEntity<ApiResponse<Void>> activatePlatform(
            @PathVariable("id") UUID id,
            @RequestParam("active") boolean active) {

        platformService.activatePlatform(id, active);
        String message = active ? "Platform activated successfully" : "Platform deactivated successfully";
        return ResponseEntity.ok(ApiResponse.success(message, null));
    }
}
