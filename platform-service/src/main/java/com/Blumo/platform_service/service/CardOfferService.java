package com.Blumo.platform_service.service;


import com.Blumo.platform_service.dto.CardOfferCreateRequest;
import com.Blumo.platform_service.dto.CardOfferResponse;

import java.util.List;
import java.util.UUID;

public interface CardOfferService {

    CardOfferResponse createOffer(CardOfferCreateRequest request);

    List<CardOfferResponse> getOffersByPlatform(UUID platformId);
}
