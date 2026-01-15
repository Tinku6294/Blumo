package com.blumo.Card_Service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data

public class CardRequestDTO {

    private String bankName;
    private String cardName;
    private String cardType;   // CREDIT / DEBIT
    private String network;    // VISA / MASTERCARD / RUPAY
    private Boolean isActive;
}
