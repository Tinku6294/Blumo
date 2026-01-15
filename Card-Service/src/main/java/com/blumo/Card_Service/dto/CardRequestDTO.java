package com.blumo.Card_Service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CardRequestDTO {

    @NotBlank(message = "Bank name must not be blank")
    private String bankName;

    @NotBlank(message = "Card name must not be blank")
    private String cardName;

    @NotBlank(message = "Card type must not be blank")
    private String cardType;
    // CREDIT / DEBIT

    @NotBlank(message = "Network must not be blank")
    private String network;
    // VISA / MASTERCARD / RUPAY

    @NotBlank(message = "Variant must not be blank")
    private String variant;
    // CLASSIC / GOLD / PLATINUM / SIGNATURE

    @NotNull(message = "Active status must not be null")
    private Boolean isActive;
}
