package com.Blumo.platform_service.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.*;
import java.util.UUID;

@Entity
@Table(name = "coupons")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private UUID platformId;   // Platform-service owns platform, so FK is OK

    @Column(nullable = false, unique = true)
    private String code;

    private String discountType;
    private BigDecimal discountValue;
    private BigDecimal maxDiscount;
    private BigDecimal minFlightPrice;

    private LocalDate validFrom;
    private LocalDate validTo;

    private Boolean isActive;

    private Instant createdAt;
    private Instant updatedAt;
}
