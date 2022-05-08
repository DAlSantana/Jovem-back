package com.aps.trabalhoAps.controllers;

import com.aps.trabalhoAps.models.Aluno;
import com.aps.trabalhoAps.models.Professor;
import com.aps.trabalhoAps.models.Turma;
import com.aps.trabalhoAps.services.TurmaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping
    public List<Turma> procurarTodosAlunos(){

        Aluno aluno01 = new Aluno("Danilo","044.222.333-22",1);
        Aluno aluno02 = new Aluno("Diego","055.222.333-22",1);
        Aluno aluno03 = new Aluno("Lucca","066.222.333-22",1);
        Aluno aluno04 = new Aluno("Leonardo","077.222.333-22",1);
        Aluno aluno05 = new Aluno("Jackson","088.222.333-22",1);
        Aluno aluno06 = new Aluno("Carlos","099.222.333-22",1);
        List<Aluno> alunos= new ArrayList<>();
        alunos.add(aluno01);
        alunos.add(aluno02);
        alunos.add(aluno03);
        alunos.add(aluno04);
        alunos.add(aluno05);
        alunos.add(aluno06);
        Professor professor  =  new Professor("Gustavo","000.222.333-22",2);
        Professor professor02  =  new Professor("Hebert","111.222.333-22",3);
        Turma turma01 = new Turma(alunos,professor);
        Turma turma02 = new Turma(alunos,professor02);
        List<Turma> turmas = new ArrayList<>();
        turmas.add(turma01);
        turmas.add(turma02);
        return turmas;
    }
}
