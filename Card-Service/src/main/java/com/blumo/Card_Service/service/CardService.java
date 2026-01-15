package com.blumo.Card_Service.service;

import com.blumo.Card_Service.dto.CardRequestDTO;
import com.blumo.Card_Service.dto.CardResponseDTO;

import java.util.List;
import java.util.UUID;

public interface CardService {

    CardResponseDTO createCard(CardRequestDTO dto);

    CardResponseDTO updateCard(UUID cardId, CardRequestDTO dto);

    CardResponseDTO getCardById(UUID cardId);

    List<CardResponseDTO> getAllActiveCards();

    void deactivateCard(UUID cardId);
    List<CardResponseDTO> getAllCards();
}
