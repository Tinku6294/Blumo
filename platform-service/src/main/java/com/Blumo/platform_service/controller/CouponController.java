package com.Blumo.platform_service.controller;
import com.Blumo.platform_service.dto.ApiResponse;
import com.Blumo.platform_service.dto.CouponCreateRequest;
import com.Blumo.platform_service.dto.CouponResponse;
import com.Blumo.platform_service.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/coupons")
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    @PostMapping
    public ResponseEntity<ApiResponse<CouponResponse>> createCoupon(
            @RequestBody CouponCreateRequest request) {
        CouponResponse response = couponService.createCoupon(request);
        return ResponseEntity.ok(ApiResponse.success("Coupon created successfully", response));
    }

    @GetMapping("/platform/{platformId}")
    public ResponseEntity<ApiResponse<List<CouponResponse>>> getCouponsByPlatform(@PathVariable UUID platformId) {
        List<CouponResponse> coupons = couponService.getCouponsByPlatform(platformId);
        return ResponseEntity.ok(ApiResponse.success("Coupons fetched successfully", coupons));
    }
}
