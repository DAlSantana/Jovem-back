package com.aps.trabalhoAps.services;

import com.aps.trabalhoAps.models.Conselho;
import com.aps.trabalhoAps.repositories.ConselhoRepository;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ConselhoService {
    @Autowired
	private ConselhoRepository conselhoRepository;

    @Transactional
    public Conselho save(Conselho conselho){
        return conselhoRepository.save(conselho);
    }
    
    public Optional<Conselho> find(UUID id){
    	var conselho = conselhoRepository.getById(id);
    	if(conselho == null) return Optional.empty();
    	return Optional.of(conselho);
    }
    
}
