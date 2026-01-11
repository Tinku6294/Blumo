package com.Blumo.platform_service.Repository;


import com.Blumo.platform_service.model.OfferRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OfferRuleRepository extends JpaRepository<OfferRule, UUID> {

    List<OfferRule> findByCouponId(UUID couponId);

    List<OfferRule> findByCardOfferId(UUID cardOfferId);
}
