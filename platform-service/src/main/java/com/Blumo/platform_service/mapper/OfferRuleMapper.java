package com.Blumo.platform_service.mapper;

import com.Blumo.platform_service.dto.OfferRuleCreateRequest;
import com.Blumo.platform_service.dto.OfferRuleResponse;
import com.Blumo.platform_service.model.OfferRule;

import java.time.Instant;

public class OfferRuleMapper {

    public static OfferRule toEntity(OfferRuleCreateRequest dto) {
        OfferRule r = new OfferRule();
        r.setCouponId(dto.getCouponId());
        r.setCardOfferId(dto.getCardOfferId());
        r.setAirline(dto.getAirline());
        r.setJourneyType(dto.getJourneyType());
        r.setDomesticInternational(dto.getDomesticInternational());
        r.setMinPax(dto.getMinPax());
        r.setMaxPax(dto.getMaxPax());
        r.setCreatedAt(Instant.now());
        return r;
    }

    public static OfferRuleResponse toResponse(OfferRule entity) {
        OfferRuleResponse dto = new OfferRuleResponse();
        dto.setId(entity.getId());
        dto.setCouponId(entity.getCouponId());
        dto.setCardOfferId(entity.getCardOfferId());
        dto.setAirline(entity.getAirline());
        dto.setJourneyType(entity.getJourneyType());
        dto.setDomesticInternational(entity.getDomesticInternational());
        dto.setMinPax(entity.getMinPax());
        dto.setMaxPax(entity.getMaxPax());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }
}
