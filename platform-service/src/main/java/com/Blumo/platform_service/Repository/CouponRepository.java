package com.Blumo.platform_service.Repository;

import com.Blumo.platform_service.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CouponRepository extends JpaRepository<Coupon, UUID> {

    List<Coupon> findByPlatformId(UUID platformId);

    boolean existsByCode(String code);
}
