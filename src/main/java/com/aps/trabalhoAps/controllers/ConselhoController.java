package com.aps.trabalhoAps.controllers;


import com.aps.trabalhoAps.models.Conselho;
import com.aps.trabalhoAps.repositories.ConselhoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conselho")
public class ConselhoController {

	@Autowired
    private ConselhoRepository conselhoRepository;

    @PostMapping
    public ResponseEntity<Object> salvarConselho(@RequestBody Conselho conselho){
        return ResponseEntity.status(HttpStatus.CREATED).body(conselhoRepository.save(conselho));
    }

    @GetMapping
    public ResponseEntity<List<Conselho>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(conselhoRepository.findAll());
    }
}
