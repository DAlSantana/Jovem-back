package com.aps.trabalhoAps.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "Aluno")
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID matricula;
    
    @Column
    private String nome;
    
    @Column
    private String cpf;
    
    @ManyToOne
    private Turma turma;

    
    public UUID getMatricula() {
        return matricula;
    }

    public void setMatricula(UUID matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTurma() {
    	return this.turma.getNomeCurso();
    }
    
    public void setTurma(Turma turma) {
    	this.turma = turma;
    }
}
