package com.aps.trabalhoAps.services;

import com.aps.trabalhoAps.domain.Error;
import com.aps.trabalhoAps.models.Conselho;
import com.aps.trabalhoAps.models.Secretaria;
import com.aps.trabalhoAps.repositories.ConselhoRepository;
import com.aps.trabalhoAps.repositories.SecretariaRepository;
import com.aps.trabalhoAps.requests.SecretariaRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SecretariaService {
	@Autowired
    private SecretariaRepository secretariaRepository;
	
	@Autowired
    private ConselhoRepository conselhoRepository;

    @Transactional
    public Optional<Secretaria> save(UUID conselhoId,SecretariaRequest secretariaRequest) {
    	var conselho = conselhoRepository.findById(conselhoId);
    	if(conselho.isEmpty()) return Optional.empty();
    	Secretaria secretaria = new Secretaria();
    	secretaria.setConselho(conselho.get());
    	secretaria.setEndereco(secretariaRequest.getEndereco());
    	secretaria.setNome(secretariaRequest.getNome());
    	secretaria.setSenha(secretariaRequest.getSenha());
    	secretaria.setTelefone(secretariaRequest.getTelefone());
    	secretariaRepository.save(secretaria);
    	return Optional.of(secretaria);
    }

    public Optional<Conselho> findById(UUID id){
       return conselhoRepository.findById(id);
    }

	public Optional<?> listarSecretarias(UUID conselhoId) {
		List<Secretaria> secretarias = secretariaRepository.findByConselhoId(conselhoId);
		if(secretarias.isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(secretarias);
	}
}
