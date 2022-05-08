package com.aps.trabalhoAps.controllers;

import com.aps.trabalhoAps.models.Ata;
import com.aps.trabalhoAps.models.Requisicao;
import com.aps.trabalhoAps.services.AtaService;
import com.aps.trabalhoAps.services.RequisicaoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requisicao")
public class RequisicaoController {

    final RequisicaoService requisicaoService;

    public RequisicaoController(RequisicaoService requisicaoService) {
        this.requisicaoService = requisicaoService;
    }

    @PostMapping
    public ResponseEntity<Object> salvarInformativo(@RequestBody Requisicao requisicao){
        return ResponseEntity.status(HttpStatus.CREATED).body(requisicaoService.save(requisicao));
    }

    @GetMapping
    public Page<Requisicao> findAll(Pageable pageable){
        return requisicaoService.recuperarTodos(pageable);
    }
}
