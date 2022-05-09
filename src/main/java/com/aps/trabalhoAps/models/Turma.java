package com.aps.trabalhoAps.models;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Turma")
public class Turma implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idTurma;

    @ManyToOne
    private Professor professor;
    
    @ManyToOne
    private Secretaria secretaria;
    
    @OneToMany
    @JoinColumn(name="aluno_matricula")
    private List<Aluno> alunos;
    
    @Column(nullable = false)
    private String nomeCurso;

    public UUID getIdTurma() {
        return idTurma;
    }
    
    public String getNomeCurso() {
    	return this.nomeCurso;
    }
    
    public void setNomeCurso(String nomeCurso) {
    	this.nomeCurso = nomeCurso;
    }

    public Professor getProfessor() {
    	return this.professor;
    }
    
    public void setProfessor(Professor professor) {
    	this.professor = professor;
    }
    
    public List<Aluno> getAlunos(){
    	return this.alunos;
    }
    
    public void setAlunos(List<Aluno> alunos) {
    	this.alunos = alunos;
    }
    
    public Secretaria getSecretaria() {
    	return this.secretaria;
    }
    
    public void setSecretaria(Secretaria secretaria) {
    	this.secretaria = secretaria;
    }
}
