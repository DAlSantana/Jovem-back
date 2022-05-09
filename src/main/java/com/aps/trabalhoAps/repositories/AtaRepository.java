package com.aps.trabalhoAps.repositories;

import com.aps.trabalhoAps.models.Ata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface AtaRepository extends JpaRepository<Ata, UUID> {
    List<Ata> findByRequisicaoId(UUID requisicao_id);
}
