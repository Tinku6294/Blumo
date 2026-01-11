package com.Blumo.platform_service.service;
import com.Blumo.platform_service.Repository.CouponRepository;
import com.Blumo.platform_service.dto.CouponCreateRequest;
import com.Blumo.platform_service.dto.CouponResponse;
import com.Blumo.platform_service.exception.DuplicateResourceException;
import com.Blumo.platform_service.mapper.CouponMapper;
import com.Blumo.platform_service.model.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {

    private final CouponRepository couponRepository;

    @Override
    public CouponResponse createCoupon(CouponCreateRequest request) {

        if (couponRepository.existsByCode(request.getCode())) {
            throw new DuplicateResourceException("Coupon code already exists");
        }

        Coupon coupon = CouponMapper.toEntity(request);
        return CouponMapper.toResponse(couponRepository.save(coupon));
    }

    @Override
    public List<CouponResponse> getCouponsByPlatform(UUID platformId) {
        return couponRepository.findByPlatformId(platformId)
                .stream()
                .map(CouponMapper::toResponse)
                .collect(Collectors.toList());
    }
}
