package com.aps.trabalhoAps.controllers;

import com.aps.trabalhoAps.models.Turma;
import com.aps.trabalhoAps.services.TurmaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turma")
public class TurmaController {
    final TurmaService turmaService;

    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @PostMapping
    public ResponseEntity<Object> saveTurma(@RequestBody Turma turma) {
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaService.save(turma));
    }
}
