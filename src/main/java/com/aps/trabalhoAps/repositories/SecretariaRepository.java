package com.aps.trabalhoAps.repositories;

import com.aps.trabalhoAps.models.Secretaria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SecretariaRepository extends JpaRepository<Secretaria, UUID> {

}
