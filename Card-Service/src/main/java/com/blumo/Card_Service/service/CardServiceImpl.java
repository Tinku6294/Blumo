package com.blumo.Card_Service.service;
import com.blumo.Card_Service.dto.CardRequestDTO;
import com.blumo.Card_Service.dto.CardResponseDTO;
import com.blumo.Card_Service.exception.BadRequestException;
import com.blumo.Card_Service.exception.DuplicateResourceException;
import com.blumo.Card_Service.exception.ResourceNotFoundException;
import com.blumo.Card_Service.mapper.CardMapper;
import com.blumo.Card_Service.model.Card;
import com.blumo.Card_Service.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    /* ================= CREATE ================= */
    @Override
    public CardResponseDTO createCard(CardRequestDTO dto) {

        validateCreateRequest(dto);

        // Duplicate check (bank + cardName)
        cardRepository.findByBankNameIgnoreCaseAndCardNameIgnoreCase(
                dto.getBankName(), dto.getCardName()
        ).ifPresent(card -> {
            throw new DuplicateResourceException(
                    "Card already exists for bank: " + dto.getBankName()
            );
        });

        Card card = CardMapper.toEntity(dto);
        Card saved = cardRepository.save(card);

        return CardMapper.toResponse(saved);
    }

    /* ================= UPDATE ================= */
    private void validateUpdateRequest(Card card, CardRequestDTO dto) {

        // cardType validation (if present)
        if (dto.getCardType() != null) {
            if (!dto.getCardType().equalsIgnoreCase("CREDIT")
                    && !dto.getCardType().equalsIgnoreCase("DEBIT")) {
                throw new BadRequestException("Card type must be CREDIT or DEBIT");
            }
        }

        // After update, mandatory fields must NOT be null
        if (card.getBankName() == null ||
                card.getCardName() == null ||
                card.getCardType() == null ||
                card.getNetwork() == null ||
                card.getIsActive() == null) {

            throw new BadRequestException(
                    "Mandatory card fields cannot be null"
            );
        }
    }

    @Override
    public CardResponseDTO updateCard(UUID cardId, CardRequestDTO dto) {

        if (cardId == null)
            throw new BadRequestException("Card ID must not be null");

        if (dto == null)
            throw new BadRequestException("Request body must not be null");

        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new ResourceNotFoundException("Card not found"));

        // Update only provided fields
        CardMapper.updateEntity(card, dto);

        // Validate after update
        validateUpdateRequest(card, dto);

        Card updated = cardRepository.save(card);
        return CardMapper.toResponse(updated);
    }


    /* ================= GET BY ID ================= */
    @Override
    public CardResponseDTO getCardById(UUID cardId) {

        if (cardId == null)
            throw new BadRequestException("Card ID must not be null");

        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new ResourceNotFoundException("Card not found"));

        return CardMapper.toResponse(card);
    }

    /* ================= GET ACTIVE ================= */
    @Override
    public List<CardResponseDTO> getAllActiveCards() {

        return cardRepository.findByIsActiveTrue()
                .stream()
                .map(CardMapper::toResponse)
                .collect(Collectors.toList());
    }
    @Override
    public List<CardResponseDTO> getAllCards() {
        List<Card> cards = cardRepository.findAll();

        if (cards.isEmpty()) {
            throw new ResourceNotFoundException("No cards found in the database.");
        }

        return cards.stream()
                .map(CardMapper::toResponse)
                .collect(Collectors.toList());
    }

    /* ================= SOFT DELETE ================= */
    @Override
    public void deactivateCard(UUID cardId) {

        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new ResourceNotFoundException("Card not found"));

        card.setIsActive(false);
        cardRepository.save(card);
    }

    /* ================= VALIDATION ================= */
    private void validateCreateRequest(CardRequestDTO dto) {

        if (dto == null)
            throw new BadRequestException("Request body must not be null");

        if (!StringUtils.hasText(dto.getBankName()))
            throw new BadRequestException("Bank name is required");

        if (!StringUtils.hasText(dto.getCardName()))
            throw new BadRequestException("Card name is required");

        if (!StringUtils.hasText(dto.getCardType()))
            throw new BadRequestException("Card type is required");

        if (!dto.getCardType().equalsIgnoreCase("CREDIT")
                && !dto.getCardType().equalsIgnoreCase("DEBIT")) {
            throw new BadRequestException("Card type must be CREDIT or DEBIT");
        }

        if (!StringUtils.hasText(dto.getNetwork()))
            throw new BadRequestException("Network is required");
    }
}
