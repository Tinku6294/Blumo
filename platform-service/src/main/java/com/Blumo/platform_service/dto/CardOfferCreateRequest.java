package com.Blumo.platform_service.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class CardOfferCreateRequest {

    @NotNull
    private UUID cardId;

    @NotNull
    private UUID platformId;

    @NotBlank
    private String discountType;

    @NotNull
    private BigDecimal discountValue;

    private BigDecimal maxDiscount;
    private BigDecimal minFlightPrice;

    @NotNull
    private LocalDate validFrom;

    @NotNull
    private LocalDate validTo;
}
