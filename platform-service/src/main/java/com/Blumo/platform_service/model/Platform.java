package com.Blumo.platform_service.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "platforms")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(nullable = false)
    private Integer priorityScore;

    private Instant createdAt;
    private Instant updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = Instant.now();
        updatedAt = Instant.now();
        if (isActive == null) isActive = true;
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = Instant.now();
    }
}

