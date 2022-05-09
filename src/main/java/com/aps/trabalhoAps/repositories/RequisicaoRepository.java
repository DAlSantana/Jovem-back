package com.aps.trabalhoAps.repositories;

import com.aps.trabalhoAps.models.Requisicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface RequisicaoRepository extends JpaRepository<Requisicao, UUID> {

	@Query(value = "SELECT * FROM requisicao WHERE secretaria_id = :id", nativeQuery = true)
	List<Requisicao> findBySecretaria_id(@Param("id") UUID id);
}
