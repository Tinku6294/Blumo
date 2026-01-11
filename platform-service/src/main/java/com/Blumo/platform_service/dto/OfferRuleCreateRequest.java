package com.Blumo.platform_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.UUID;

@Data
public class OfferRuleCreateRequest {

    @NotNull
    private UUID couponId;

    private UUID cardOfferId;

    private String airline;
    private String journeyType;
    private String domesticInternational;

    private Integer minPax;
    private Integer maxPax;
}
