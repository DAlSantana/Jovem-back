package com.aps.trabalhoAps.repositories;

import com.aps.trabalhoAps.models.Ata;
import com.aps.trabalhoAps.models.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TurmaRepository extends JpaRepository<Turma, UUID> {
    List<Turma> findBySecretariaId(UUID secretaria_id);
}
