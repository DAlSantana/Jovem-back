package com.aps.trabalhoAps.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Materia")
public class Materia {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idMateria;
    
    @OneToOne
    @JoinColumn(name = "idMateria", referencedColumnName = "id")
    private Professor professor;
    
    @Column
    private String nomeMateria;

    public UUID getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(UUID idMateria) {
        this.idMateria = idMateria;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getNomeMateria() {
        return nomeMateria;
    }

    public void setNomeMateria(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    private float nota;
}
