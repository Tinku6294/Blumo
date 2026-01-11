package com.Blumo.platform_service.service;


import com.Blumo.platform_service.dto.OfferRuleCreateRequest;
import com.Blumo.platform_service.dto.OfferRuleResponse;

import java.util.List;
import java.util.UUID;

public interface OfferRuleService {

    OfferRuleResponse createRule(OfferRuleCreateRequest request);

    List<OfferRuleResponse> getRulesByCoupon(UUID couponId);
}
