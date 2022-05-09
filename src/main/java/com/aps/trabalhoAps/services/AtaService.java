package com.aps.trabalhoAps.services;


import com.aps.trabalhoAps.domain.Error;
import com.aps.trabalhoAps.models.Ata;
import com.aps.trabalhoAps.models.Informativo;
import com.aps.trabalhoAps.models.Requisicao;
import com.aps.trabalhoAps.repositories.AtaRepository;
import com.aps.trabalhoAps.repositories.RequisicaoRepository;
import com.aps.trabalhoAps.requests.AtaRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AtaService {
    @Autowired
	private AtaRepository ataRepository;
    
    @Autowired
    private RequisicaoRepository requisicaoRepository;

    @Transactional
    public Optional<?> save(AtaRequest ataRequest) {
    	Optional<Requisicao> requisicao = requisicaoRepository.findById(ataRequest.getRequisicao());
    	if(requisicao.isEmpty()) {
    		Error error = new Error();
    		error.setStatus(HttpStatus.NOT_FOUND);
    		error.setMessage("Requisicao não encontrada.");
    	}
    	Ata ata = new Ata();
    	ata.setDescricao(ataRequest.getDescricao());
    	ata.setSubtitulo(ataRequest.getSubtitulo());
    	ata.setTitulo(ataRequest.getTitulo());
    	ata.setRequisicao(requisicao.get());
        return Optional.of(ataRepository.save(ata));
    }

    public Optional<Ata> findById(UUID id){
        return ataRepository.findById(id);
    }

    public List<Ata> recuperarTodos() {
        return ataRepository.findAll();
    }

}
