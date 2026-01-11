package com.Blumo.platform_service.dto;

import lombok.Data;
import java.time.Instant;
import java.util.UUID;

@Data
public class OfferRuleResponse {

    private UUID id;
    private UUID couponId;
    private UUID cardOfferId;
    private String airline;
    private String journeyType;
    private String domesticInternational;
    private Integer minPax;
    private Integer maxPax;
    private Instant createdAt;
}
