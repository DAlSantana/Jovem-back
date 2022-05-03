package com.aps.trabalhoAps.services;

import com.aps.trabalhoAps.models.Aluno;
import com.aps.trabalhoAps.models.HistoricoEscolar;
import com.aps.trabalhoAps.repositories.HistoricoEscolarRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class HistoricoEscolarService {
    final HistoricoEscolarRepository historicoEscolarRepository;

    public HistoricoEscolarService(HistoricoEscolarRepository historicoEscolarRepository) {
        this.historicoEscolarRepository = historicoEscolarRepository;
    }

    @Transactional
    public HistoricoEscolar save(Aluno aluno){
        return historicoEscolarRepository.save( this.atrelarHistoricoAoAluno(aluno));
    }

    public HistoricoEscolar atrelarHistoricoAoAluno(Aluno aluno) {
         HistoricoEscolar historicoEscolar = new HistoricoEscolar();
         historicoEscolar.setAluno(aluno);
         return historicoEscolar;
    }
}
