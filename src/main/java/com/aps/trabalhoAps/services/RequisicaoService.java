package com.aps.trabalhoAps.services;


import com.aps.trabalhoAps.domain.Error;
import com.aps.trabalhoAps.models.Requisicao;
import com.aps.trabalhoAps.models.Secretaria;
import com.aps.trabalhoAps.repositories.RequisicaoRepository;
import com.aps.trabalhoAps.repositories.SecretariaRepository;
import com.aps.trabalhoAps.requests.RequisicaoRequest;

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
public class RequisicaoService {

	@Autowired
    private RequisicaoRepository requisicaoRepository;
	
	@Autowired
	private SecretariaRepository secretariaRepository;

    @Transactional
    public Optional<?> save(RequisicaoRequest requisicaoRequest) {
    	Optional<Secretaria> secretaria = secretariaRepository.findById(requisicaoRequest.getSecretaria());
    	if(secretaria.isEmpty()) {
    		Error error = new Error();
    		error.setStatus(HttpStatus.NOT_FOUND);
    		error.setMessage("Secretaria não encontrada");
    		return Optional.of(error);
    	}
    	Requisicao requisicao = new Requisicao();
    	requisicao.setDescricao(requisicaoRequest.getDescricao());
    	requisicao.setSubtitulo(requisicaoRequest.getSubtitulo());
    	requisicao.setTitulo(requisicaoRequest.getTitulo());
    	requisicao.setSecretaria(secretaria.get());
    	
        return Optional.of(requisicaoRepository.save(requisicao));
    }

    public Optional<Requisicao> findById(UUID id){
        return requisicaoRepository.findById(id);
    }

    public List<Requisicao> recuperarTodos() {
        return requisicaoRepository.findAll();
    }
}
