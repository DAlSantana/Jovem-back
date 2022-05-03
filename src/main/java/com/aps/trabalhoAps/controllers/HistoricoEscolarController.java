package com.aps.trabalhoAps.controllers;


import com.aps.trabalhoAps.models.HistoricoEscolar;
import com.aps.trabalhoAps.services.HistoricoEscolarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/historico-escolar")
public class HistoricoEscolarController {
    final HistoricoEscolarService historicoEscolarService;

    public HistoricoEscolarController(HistoricoEscolarService historicoEscolarService) {
        this.historicoEscolarService = historicoEscolarService;
    }

    @RequestMapping
    public ResponseEntity<Object> criarHistoricoEscolar(@RequestBody HistoricoEscolar historico){
        return ResponseEntity.status(HttpStatus.CREATED).body(historicoEscolarService.save(historico));
    }
}
