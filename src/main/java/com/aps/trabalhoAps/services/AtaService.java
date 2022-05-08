package com.aps.trabalhoAps.services;


import com.aps.trabalhoAps.models.Ata;
import com.aps.trabalhoAps.models.Informativo;
import com.aps.trabalhoAps.repositories.AtaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class AtaService {
    final AtaRepository ataRepository;

    public AtaService(AtaRepository ataRepository) {
        this.ataRepository = ataRepository;
    }

    @Transactional
    public Ata save(Ata ata) {
        return ataRepository.save(ata);
    }

    public Optional<Ata> findById(UUID id){
        return ataRepository.findById(id);
    }

    public Page<Ata> recuperarTodos(Pageable pageable) {
        return ataRepository.findAll(pageable);
    }

}
