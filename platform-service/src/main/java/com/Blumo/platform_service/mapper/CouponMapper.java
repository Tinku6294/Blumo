package com.Blumo.platform_service.mapper;


import com.Blumo.platform_service.dto.CouponCreateRequest;
import com.Blumo.platform_service.dto.CouponResponse;
import com.Blumo.platform_service.model.Coupon;

import java.time.Instant;

public class CouponMapper {

    public static Coupon toEntity(CouponCreateRequest dto) {
        Coupon c = new Coupon();
        c.setPlatformId(dto.getPlatformId());
        c.setCode(dto.getCode());
        c.setDiscountType(dto.getDiscountType());
        c.setDiscountValue(dto.getDiscountValue());
        c.setMaxDiscount(dto.getMaxDiscount());
        c.setMinFlightPrice(dto.getMinFlightPrice());
        c.setValidFrom(dto.getValidFrom());
        c.setValidTo(dto.getValidTo());
        c.setIsActive(true);
        c.setCreatedAt(Instant.now());
        c.setUpdatedAt(Instant.now());
        return c;
    }

    public static CouponResponse toResponse(Coupon entity) {
        CouponResponse dto = new CouponResponse();
        dto.setId(entity.getId());
        dto.setPlatformId(entity.getPlatformId());
        dto.setCode(entity.getCode());
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
