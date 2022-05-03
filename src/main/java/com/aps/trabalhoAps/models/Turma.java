package com.aps.trabalhoAps.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Turma")
public class Turma {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idTurma;

    private Integer idAluno;
    private Integer idProfessor;

    public UUID getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(UUID idTurma) {
        this.idTurma = idTurma;
    }

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public Integer getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Integer idProfessor) {
        this.idProfessor = idProfessor;
    }
}
