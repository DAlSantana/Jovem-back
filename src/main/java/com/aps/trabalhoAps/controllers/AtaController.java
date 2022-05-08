package com.aps.trabalhoAps.controllers;

import com.aps.trabalhoAps.models.Ata;
import com.aps.trabalhoAps.services.AtaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/ata")
public class AtaController {
    final AtaService ataService;

    public AtaController(AtaService ataService) {
        this.ataService = ataService;
    }

    @PostMapping
    public ResponseEntity<Object> salvarAta(@RequestBody Ata ata){
        return ResponseEntity.status(HttpStatus.CREATED).body(ataService.save(ata));
    }

    @GetMapping
    public Page<Ata> findAll(Pageable pageable){
        return ataService.recuperarTodos(pageable);
    }
}
