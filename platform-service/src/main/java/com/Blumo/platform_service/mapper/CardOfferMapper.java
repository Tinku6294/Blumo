package com.Blumo.platform_service.mapper;


import com.Blumo.platform_service.dto.CardOfferCreateRequest;
import com.Blumo.platform_service.dto.CardOfferResponse;
import com.Blumo.platform_service.model.CardOffer;

import java.time.Instant;

public class CardOfferMapper {

    public static CardOffer toEntity(CardOfferCreateRequest dto) {
        CardOffer o = new CardOffer();
        o.setCardId(dto.getCardId());
        o.setPlatformId(dto.getPlatformId());
        o.setDiscountType(dto.getDiscountType());
        o.setDiscountValue(dto.getDiscountValue());
        o.setMaxDiscount(dto.getMaxDiscount());
        o.setMinFlightPrice(dto.getMinFlightPrice());
        o.setValidFrom(dto.getValidFrom());
        o.setValidTo(dto.getValidTo());
        o.setIsActive(true);
        o.setCreatedAt(Instant.now());
        o.setUpdatedAt(Instant.now());
        return o;
    }

    public static CardOfferResponse toResponse(CardOffer entity) {
        CardOfferResponse dto = new CardOfferResponse();
        dto.setId(entity.getId());
        dto.setCardId(entity.getCardId());
        dto.setPlatformId(entity.getPlatformId());
        dto.setDiscountType(entity.getDiscountType());
        dto.setDiscountValue(entity.getDiscountValue());
        dto.setMaxDiscount(entity.getMaxDiscount());
        dto.setMinFlightPrice(entity.getMinFlightPrice());
        dto.setValidFrom(entity.getValidFrom());
        dto.setValidTo(entity.getValidTo());
        dto.setIsActive(entity.getIsActive());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }
}
