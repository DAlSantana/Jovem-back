package com.aps.trabalhoAps.services;

import com.aps.trabalhoAps.models.Conselho;
import com.aps.trabalhoAps.models.Secretaria;
import com.aps.trabalhoAps.repositories.ConselhoRepository;
import com.aps.trabalhoAps.repositories.SecretariaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class SecretariaService {
    final SecretariaRepository secretariaRepository;
    final ConselhoRepository conselhoRepository;

    public SecretariaService(SecretariaRepository secretariaRepository, ConselhoRepository conselhoRepository) {
        this.secretariaRepository = secretariaRepository;
        this.conselhoRepository = conselhoRepository;
    }

    @Transactional
    public Secretaria save(Secretaria secretaria) {
        return secretariaRepository.save(secretaria);
    }

    public Optional<Conselho> findById(UUID id){
       return conselhoRepository.findById(id);
    }
}
