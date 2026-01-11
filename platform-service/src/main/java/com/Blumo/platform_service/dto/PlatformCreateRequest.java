package com.Blumo.platform_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PlatformCreateRequest {

    @NotBlank
    private String name;

    @NotNull
    private Integer priorityScore;
}
