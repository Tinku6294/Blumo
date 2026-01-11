package com.Blumo.platform_service.Repository;

import com.Blumo.platform_service.model.CardOffer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CardOfferRepository extends JpaRepository<CardOffer, UUID> {

    List<CardOffer> findByPlatformId(UUID platformId);

    List<CardOffer> findByCardId(UUID cardId);
}
