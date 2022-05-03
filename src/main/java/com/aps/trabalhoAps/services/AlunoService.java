package com.aps.trabalhoAps.services;

import com.aps.trabalhoAps.models.Aluno;
import com.aps.trabalhoAps.repositories.AlunoRepository;
import com.aps.trabalhoAps.repositories.HistoricoEscolarRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AlunoService {
    final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Transactional
    public Aluno save(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public Page<Aluno> recuperarTodos(Pageable pageable) {
        return alunoRepository.findAll(pageable);
    }

}
