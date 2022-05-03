package com.aps.trabalhoAps.repositories;

import com.aps.trabalhoAps.models.Conselho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ConselhoRepository extends JpaRepository<Conselho, UUID> {
    boolean existsConselhoById(UUID id);
}
