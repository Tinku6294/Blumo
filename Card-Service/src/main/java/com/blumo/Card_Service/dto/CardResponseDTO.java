package com.blumo.Card_Service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
public class CardResponseDTO {

    private UUID id;
    private String bankName;
    private String cardName;
    private String cardType;
    private String network;
    private Boolean isActive;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
