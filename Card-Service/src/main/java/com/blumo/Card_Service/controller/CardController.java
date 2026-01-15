package com.blumo.Card_Service.controller;

import com.blumo.Card_Service.dto.ApiResponse;
import com.blumo.Card_Service.dto.CardRequestDTO;
import com.blumo.Card_Service.dto.CardResponseDTO;

import com.blumo.Card_Service.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    /* ================= CREATE CARD ================= */
    @PostMapping
    public ResponseEntity<ApiResponse<CardResponseDTO>> createCard(
            @RequestBody CardRequestDTO dto
    ) {
        CardResponseDTO response = cardService.createCard(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.success("Card created successfully", response)
        );
    }

    /* ================= UPDATE CARD ================= */
    @PutMapping("/{cardId}")
    public ResponseEntity<ApiResponse<CardResponseDTO>> updateCard(
            @PathVariable UUID cardId,
            @RequestBody CardRequestDTO dto
    ) {
        CardResponseDTO response = cardService.updateCard(cardId, dto);
        return ResponseEntity.ok(
                ApiResponse.success("Card updated successfully", response)
        );
    }

    /* ================= GET CARD BY ID ================= */
    @GetMapping("/{cardId}")
    public ResponseEntity<ApiResponse<CardResponseDTO>> getCardById(
            @PathVariable UUID cardId
    ) {
        CardResponseDTO response = cardService.getCardById(cardId);
        return ResponseEntity.ok(
                ApiResponse.success("Card fetched successfully", response)
        );
    }

    /* ================= GET ALL ACTIVE CARDS ================= */
    @GetMapping
    public ResponseEntity<ApiResponse<List<CardResponseDTO>>> getAllActiveCards() {
        List<CardResponseDTO> cards = cardService.getAllActiveCards();
        return ResponseEntity.ok(
                ApiResponse.success("Active cards fetched successfully", cards)
        );
    }
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<CardResponseDTO>>> getAllCards() {
        List<CardResponseDTO> cards = cardService.getAllCards();
        return ResponseEntity.ok(
                ApiResponse.success("All cards fetched successfully", cards)
        );
    }


    /* ================= DEACTIVATE CARD ================= */
    @DeleteMapping("/{cardId}")
    public ResponseEntity<ApiResponse<Void>> deactivateCard(
            @PathVariable UUID cardId
    ) {
        cardService.deactivateCard(cardId);
        return ResponseEntity.ok(
                ApiResponse.success("Card deactivated successfully", null)
        );
    }
    @PatchMapping("/{cardId}")
    public ResponseEntity<ApiResponse<CardResponseDTO>> patchCard(
            @PathVariable UUID cardId,
            @RequestBody CardRequestDTO dto
    ) {
        return ResponseEntity.ok(
                ApiResponse.success(
                        "Card updated successfully",
                        cardService.updateCard(cardId, dto)
                )
        );
    }

}
