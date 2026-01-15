package com.blumo.Card_Service.mapper;

import com.blumo.Card_Service.dto.CardRequestDTO;
import com.blumo.Card_Service.dto.CardResponseDTO;
import com.blumo.Card_Service.model.Card;

import java.time.LocalDateTime;

public class CardMapper {

    private CardMapper() {
        // utility class
    }

    /**
     * Convert Request DTO to Entity (CREATE)
     */
    public static Card toEntity(CardRequestDTO dto) {
        Card card = new Card();

        card.setBankName(dto.getBankName());
        card.setCardName(dto.getCardName());
        card.setCardType(dto.getCardType());
        card.setNetwork(dto.getNetwork());
        card.setVariant(dto.getVariant());
        card.setIsActive(dto.getIsActive());

        card.setCreatedAt(LocalDateTime.now());
        card.setUpdatedAt(LocalDateTime.now());

        return card;
    }

    /**
     * Convert Entity to Response DTO (READ)
     */
    public static CardResponseDTO toResponse(Card card) {
        CardResponseDTO dto = new CardResponseDTO();

        dto.setId(card.getId());
        dto.setBankName(card.getBankName());
        dto.setCardName(card.getCardName());
        dto.setCardType(card.getCardType());
        dto.setNetwork(card.getNetwork());
        dto.setVariant(card.getVariant());
        dto.setIsActive(card.getIsActive());
        dto.setCreatedAt(card.getCreatedAt());
        dto.setUpdatedAt(card.getUpdatedAt());

        return dto;
    }

    /**
     * Update Entity from DTO (PARTIAL UPDATE)
     * Only non-null fields will be updated
     */
    public static void updateEntity(Card card, CardRequestDTO dto) {

        if (dto.getBankName() != null)
            card.setBankName(dto.getBankName());

        if (dto.getCardName() != null)
            card.setCardName(dto.getCardName());

        if (dto.getCardType() != null)
            card.setCardType(dto.getCardType());

        if (dto.getNetwork() != null)
            card.setNetwork(dto.getNetwork());

        if (dto.getVariant() != null)
            card.setVariant(dto.getVariant());

        if (dto.getIsActive() != null)
            card.setIsActive(dto.getIsActive());

        card.setUpdatedAt(LocalDateTime.now());
    }
}
