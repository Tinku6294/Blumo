package com.Blumo.platform_service.Repository;

import com.Blumo.platform_service.model.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlatformRepository extends JpaRepository<Platform, UUID> {

    boolean existsByName(String name);
}
