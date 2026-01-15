package com.blumo.Card_Service.mapper;


import com.blumo.Card_Service.dto.CardRequestDTO;
import com.blumo.Card_Service.dto.CardResponseDTO;
import com.blumo.Card_Service.model.Card;

import java.time.LocalDateTime;

public class CardMapper {

    private CardMapper() {
        // utility class
    }

    public static Card toEntity(CardRequestDTO dto) {
        Card card = new Card();
        card.setBankName(dto.getBankName());
        card.setCardName(dto.getCardName());
        card.setCardType(dto.getCardType());
        card.setNetwork(dto.getNetwork());
        card.setIsActive(dto.getIsActive());
        card.setCreatedAt(LocalDateTime.now());
        card.setUpdatedAt(LocalDateTime.now());
        return card;
    }

    public static CardResponseDTO toResponse(Card card) {
        CardResponseDTO dto = new CardResponseDTO();
        dto.setId(card.getId());
        dto.setBankName(card.getBankName());
        dto.setCardName(card.getCardName());
        dto.setCardType(card.getCardType());
        dto.setNetwork(card.getNetwork());
        dto.setIsActive(card.getIsActive());
        dto.setCreatedAt(card.getCreatedAt());
        dto.setUpdatedAt(card.getUpdatedAt());
        return dto;
    }

    public static void updateEntity(Card card, CardRequestDTO dto) {

        if (dto.getBankName() != null)
            card.setBankName(dto.getBankName());

        if (dto.getCardName() != null)
            card.setCardName(dto.getCardName());

        if (dto.getCardType() != null)
            card.setCardType(dto.getCardType());

        if (dto.getNetwork() != null)
            card.setNetwork(dto.getNetwork());

        if (dto.getIsActive() != null)
            card.setIsActive(dto.getIsActive());

        card.setUpdatedAt(LocalDateTime.now());
    }

}
