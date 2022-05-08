package com.aps.trabalhoAps.repositories;

import com.aps.trabalhoAps.models.Requisicao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RequisicaoRepository extends JpaRepository<Requisicao, UUID> {
}
