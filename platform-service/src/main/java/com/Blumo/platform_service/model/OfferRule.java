package com.Blumo.platform_service.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "offer_rules")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class OfferRule {

    @Id
    @GeneratedValue
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
