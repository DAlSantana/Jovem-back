package com.aps.trabalhoAps.controllers;

import com.aps.trabalhoAps.models.Aluno;
import com.aps.trabalhoAps.models.Professor;
import com.aps.trabalhoAps.services.ProfessorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

@RestController
@RequestMapping("/professor")
public class ProfessorControler {
    final ProfessorService professorService;

    public ProfessorControler(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping
    public ResponseEntity<Object> salvarProfessor(@RequestBody Professor professor){
        return ResponseEntity.status(HttpStatus.CREATED).body(professorService.save(professor));
    }

    @GetMapping
    public ResponseEntity<Page<Professor>> recuperarTodosOsProfessores(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(professorService.recuperarTodos(pageable));
    }
}
