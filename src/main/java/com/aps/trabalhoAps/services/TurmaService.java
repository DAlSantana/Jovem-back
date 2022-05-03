package com.aps.trabalhoAps.services;

import com.aps.trabalhoAps.models.Turma;
import com.aps.trabalhoAps.repositories.TurmaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TurmaService {
    final TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    @Transactional
    public Turma save(Turma turma){
        return turmaRepository.save(turma);
    }
}
