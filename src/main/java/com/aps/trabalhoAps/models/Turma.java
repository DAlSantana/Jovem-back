package com.aps.trabalhoAps.models;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Turma")
public class Turma {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idTurma;

    @Column(nullable = false)
    @OneToMany
    @JoinColumn(name = "matricula")
    private List<Aluno> alunos;

    private Professor professor;

    public Turma() {

    }

    public UUID getIdTurma() {
        return idTurma;
    }

    public Turma(List<Aluno> alunos, Professor professor) {
        this.alunos = alunos;
        this.professor = professor;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public void setIdTurma(UUID idTurma) {
        this.idTurma = idTurma;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
