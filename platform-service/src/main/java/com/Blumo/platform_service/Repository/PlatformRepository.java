package com.Blumo.platform_service.Repository;

import com.Blumo.platform_service.model.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PlatformRepository extends JpaRepository<Platform, UUID> {

    boolean existsByName(String name);
    Optional<Platform> findByNameIgnoreCase(String name);
    // Check if a platform exists by name (case-insensitive)
    boolean existsByNameIgnoreCase(String name);
}
