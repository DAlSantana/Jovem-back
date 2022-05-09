package com.aps.trabalhoAps.controllers;

import com.aps.trabalhoAps.domain.Error;
import com.aps.trabalhoAps.models.Aluno;
import com.aps.trabalhoAps.models.Professor;
import com.aps.trabalhoAps.requests.ProfessorRequest;
import com.aps.trabalhoAps.services.ProfessorService;

import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.Optional;

@RestController
@RequestMapping("/professor")
public class ProfessorControler {
	
	@Autowired
    private ProfessorService professorService;

    @PostMapping
    public ResponseEntity<Object> salvarProfessor(@RequestBody ProfessorRequest professorRequest){
    	Optional<?> professorOpt = professorService.save(professorRequest);
    	if(professorOpt.get() instanceof Error) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(professorOpt.get());
    	}
		return ResponseEntity.status(HttpStatus.CREATED).body(professorOpt.get());
        
    }

    @GetMapping
    public ResponseEntity<Page<Professor>> recuperarTodosOsProfessores(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(professorService.recuperarTodos(pageable));
    }
}
