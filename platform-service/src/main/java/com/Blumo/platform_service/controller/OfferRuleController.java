package com.Blumo.platform_service.controller;
import com.Blumo.platform_service.dto.ApiResponse;
import com.Blumo.platform_service.dto.OfferRuleCreateRequest;
import com.Blumo.platform_service.dto.OfferRuleResponse;
import com.Blumo.platform_service.service.OfferRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/offer-rules")
@RequiredArgsConstructor
public class OfferRuleController {

    private final OfferRuleService offerRuleService;

    @PostMapping
    public ResponseEntity<ApiResponse<OfferRuleResponse>> createRule(
            @RequestBody OfferRuleCreateRequest request) {
        OfferRuleResponse response = offerRuleService.createRule(request);
        return ResponseEntity.ok(ApiResponse.success("Offer rule created successfully", response));
    }

    @GetMapping("/coupon/{couponId}")
    public ResponseEntity<ApiResponse<List<OfferRuleResponse>>> getRulesByCoupon(@PathVariable UUID couponId) {
        List<OfferRuleResponse> rules = offerRuleService.getRulesByCoupon(couponId);
        return ResponseEntity.ok(ApiResponse.success("Offer rules fetched successfully", rules));
    }
}
