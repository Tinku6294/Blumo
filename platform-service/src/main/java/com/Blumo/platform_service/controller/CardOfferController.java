package com.Blumo.platform_service.controller;
import com.Blumo.platform_service.dto.ApiResponse;
import com.Blumo.platform_service.dto.CardOfferCreateRequest;
import com.Blumo.platform_service.dto.CardOfferResponse;
import com.Blumo.platform_service.service.CardOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/card-offers")
@RequiredArgsConstructor
public class CardOfferController {

    private final CardOfferService cardOfferService;

    @PostMapping
    public ResponseEntity<ApiResponse<CardOfferResponse>> createOffer(
            @RequestBody CardOfferCreateRequest request) {
        CardOfferResponse response = cardOfferService.createOffer(request);
        return ResponseEntity.ok(ApiResponse.success("Card offer created successfully", response));
    }

    @GetMapping("/platform/{platformId}")
    public ResponseEntity<ApiResponse<List<CardOfferResponse>>> getOffersByPlatform(@PathVariable UUID platformId) {
        List<CardOfferResponse> offers = cardOfferService.getOffersByPlatform(platformId);
        return ResponseEntity.ok(ApiResponse.success("Card offers fetched successfully", offers));
    }
}
