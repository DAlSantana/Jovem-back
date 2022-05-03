package com.aps.trabalhoAps.repositories;

import com.aps.trabalhoAps.models.HistoricoEscolar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HistoricoEscolarRepository  extends JpaRepository<HistoricoEscolar, UUID> {
}
