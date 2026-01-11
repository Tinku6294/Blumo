package com.Blumo.platform_service.service;


import com.Blumo.platform_service.Repository.OfferRuleRepository;
import com.Blumo.platform_service.dto.OfferRuleCreateRequest;
import com.Blumo.platform_service.dto.OfferRuleResponse;
import com.Blumo.platform_service.mapper.OfferRuleMapper;
import com.Blumo.platform_service.model.OfferRule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OfferRuleServiceImpl implements OfferRuleService {

    private final OfferRuleRepository repository;

    @Override
    public OfferRuleResponse createRule(OfferRuleCreateRequest request) {
        OfferRule rule = OfferRuleMapper.toEntity(request);
        return OfferRuleMapper.toResponse(repository.save(rule));
    }

    @Override
    public List<OfferRuleResponse> getRulesByCoupon(UUID couponId) {
        return repository.findByCouponId(couponId)
                .stream()
                .map(OfferRuleMapper::toResponse)
                .collect(Collectors.toList());
    }
}
