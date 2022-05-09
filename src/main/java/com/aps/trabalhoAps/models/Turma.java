package com.aps.trabalhoAps.models;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "Turma")
public class Turma implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idTurma;

    @ManyToOne(cascade = CascadeType.ALL)
    private Professor professor;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Secretaria secretaria;
    
    @OneToMany(cascade = CascadeType.ALL)
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

    public String getProfessor() {
    	return this.professor.getNome();
    }
    
    public void setProfessor(Professor professor) {
    	this.professor = professor;
    }
    
    public List<String> getAlunos(){
    	return this.alunos.stream().map(Aluno::getNome).collect(Collectors.toList());
    }
    
    public void setAlunos(List<Aluno> alunos) {
    	this.alunos = alunos;
    }
    
    public String getSecretaria() {
    	return this.secretaria.getNome();
    }
    
    public void setSecretaria(Secretaria secretaria) {
    	this.secretaria = secretaria;
    }
}
