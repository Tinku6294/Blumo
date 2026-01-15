package com.blumo.Card_Service.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String bankName;

    @Column(nullable = false)
    private String cardName;

    @Column(nullable = false)
    private String cardType;
    // CREDIT / DEBIT

    @Column(nullable = false)
    private String network;
    // VISA / MASTERCARD / RUPAY

    @Column(nullable = false)
    private String variant;
    // CLASSIC / GOLD / PLATINUM / SIGNATURE

    @Column(nullable = false)
    private Boolean isActive;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
