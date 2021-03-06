package com.aps.trabalhoAps.controllers;

import com.aps.trabalhoAps.models.Aluno;
import com.aps.trabalhoAps.services.AlunoService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/aluno")
public class AlunoController {
  final AlunoService alunoService;
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<Object> salvarAluno(@RequestBody Aluno alunoDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.save(alunoDto));
    }

    @GetMapping
    public ResponseEntity<Page<Aluno>> recuperarTodosOsAlunos(@PageableDefault(page = 0, size = 10, sort = "matricula", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.recuperarTodos(pageable));
    }
}
