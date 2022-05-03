package com.aps.trabalhoAps.services;

import com.aps.trabalhoAps.models.Conselho;
import com.aps.trabalhoAps.repositories.ConselhoRepository;

import javax.transaction.Transactional;

public class ConselhoService {
    final ConselhoRepository conselhoRepository;

    public ConselhoService(ConselhoRepository conselhoRepository){
        this.conselhoRepository = conselhoRepository;
    }

    @Transactional
    public Conselho save(Conselho conselho){
        return conselhoRepository.save(conselho);
    }
}
