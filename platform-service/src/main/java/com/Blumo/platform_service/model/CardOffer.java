package com.Blumo.platform_service.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.*;
import java.util.UUID;

@Entity
@Table(name = "card_offers")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardOffer {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private UUID cardId;      // from Card Service

    @Column(nullable = false)
    private UUID platformId;

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
