package com.aps.trabalhoAps.controllers;

import com.aps.trabalhoAps.domain.Error;
import com.aps.trabalhoAps.models.Aluno;
import com.aps.trabalhoAps.models.Ata;
import com.aps.trabalhoAps.models.Professor;
import com.aps.trabalhoAps.models.Turma;
import com.aps.trabalhoAps.requests.TurmaRequest;
import com.aps.trabalhoAps.services.TurmaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/turma")
public class TurmaController {
    @Autowired
	private TurmaService turmaService;

    @PostMapping
    public ResponseEntity<Object> saveTurma(@RequestBody TurmaRequest turma) {
    	Optional<?> turmaOpt =  turmaService.save(turma);
    	if(turmaOpt.get() instanceof Error) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(turmaOpt.get());
    	}
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaOpt.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Turma>> findBySecretariaId(@PathVariable(value = "id") UUID id) {
        return new ResponseEntity<List<Turma>>(turmaService.findBySecretariaId(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Turma>> procurarTodosAlunos(){
      return ResponseEntity.status(HttpStatus.OK).body(turmaService.recuperarTodos());
    }
}
