package com.aps.trabalhoAps.controllers;


import com.aps.trabalhoAps.models.Conselho;
import com.aps.trabalhoAps.repositories.ConselhoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conselho")
public class ConselhoController {

    final ConselhoRepository conselhoRepository;

    public ConselhoController(ConselhoRepository conselhoRepository) {
        this.conselhoRepository = conselhoRepository;
    }

    @PostMapping
    public ResponseEntity<Object> salvarConselho(@RequestBody Conselho conselho){
        return ResponseEntity.status(HttpStatus.CREATED).body(conselhoRepository.save(conselho));
    }

    @GetMapping
    public Page<Conselho> findAll(Pageable pageable) {
        return conselhoRepository.findAll(pageable);
    }
}
