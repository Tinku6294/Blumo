package com.Blumo.platform_service.service;

import com.Blumo.platform_service.Repository.CardOfferRepository;
import com.Blumo.platform_service.dto.CardOfferCreateRequest;
import com.Blumo.platform_service.dto.CardOfferResponse;
import com.Blumo.platform_service.mapper.CardOfferMapper;
import com.Blumo.platform_service.mapper.OfferRuleMapper;
import com.Blumo.platform_service.model.CardOffer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardOfferServiceImpl implements CardOfferService {

    private final CardOfferRepository repository;

    @Override
    public CardOfferResponse createOffer(CardOfferCreateRequest request) {
        CardOffer offer = CardOfferMapper.toEntity(request);
        return CardOfferMapper.toResponse(repository.save(offer));
    }

    @Override
    public List<CardOfferResponse> getOffersByPlatform(UUID platformId) {
        return repository.findByPlatformId(platformId)
                .stream()
                .map(CardOfferMapper::toResponse)
                .collect(Collectors.toList());
    }
}
