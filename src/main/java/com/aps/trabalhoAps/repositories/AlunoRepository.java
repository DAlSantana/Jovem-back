package com.aps.trabalhoAps.repositories;

import com.aps.trabalhoAps.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AlunoRepository extends JpaRepository<Aluno, UUID> {

}
