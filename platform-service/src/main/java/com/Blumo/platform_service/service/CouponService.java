package com.Blumo.platform_service.service;


import com.Blumo.platform_service.dto.CouponCreateRequest;
import com.Blumo.platform_service.dto.CouponResponse;

import java.util.List;
import java.util.UUID;

public interface CouponService {

    CouponResponse createCoupon(CouponCreateRequest request);

    List<CouponResponse> getCouponsByPlatform(UUID platformId);
}
