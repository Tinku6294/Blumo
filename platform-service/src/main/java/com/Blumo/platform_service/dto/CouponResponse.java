package com.Blumo.platform_service.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.*;
import java.util.UUID;

@Data
public class CouponResponse {

    private UUID id;
    private UUID platformId;
    private String code;
    private String discountType;
    private BigDecimal discountValue;
    private BigDecimal maxDiscount;
    private BigDecimal minFlightPrice;
    private LocalDate validFrom;
    private LocalDate validTo;
    private Boolean isActive;
    private Instant createdAt;
}
