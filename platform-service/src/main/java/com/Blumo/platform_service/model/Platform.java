package com.Blumo.platform_service.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "platforms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Platform {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "is_active")
    private Boolean isActive;

    private Integer priorityScore;

    private Instant createdAt;
    private Instant updatedAt;
}
