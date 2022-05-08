package com.aps.trabalhoAps.services;


import com.aps.trabalhoAps.models.Requisicao;
import com.aps.trabalhoAps.repositories.RequisicaoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class RequisicaoService {

    final RequisicaoRepository requisicaoRepository;

    public RequisicaoService(RequisicaoRepository requisicaoRepository) {
        this.requisicaoRepository = requisicaoRepository;
    }

    @Transactional
    public Requisicao save(Requisicao requisicao) {
        return requisicaoRepository.save(requisicao);
    }

    public Optional<Requisicao> findById(UUID id){
        return requisicaoRepository.findById(id);
    }

    public Page<Requisicao> recuperarTodos(Pageable pageable) {
        return requisicaoRepository.findAll(pageable);
    }
}
