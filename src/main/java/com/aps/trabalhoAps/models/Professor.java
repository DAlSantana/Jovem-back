package com.aps.trabalhoAps.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Professor")
public class Professor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column
    private String nome;
    
    @Column
    private String cpf;
    
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Secretaria> secretarias = new ArrayList<Secretaria>();
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="turma_id")
    private List<Turma> turmas;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public List<Secretaria> getSecretarias(){
    	return this.secretarias;
    }
    
    public void setSecretarias(List<Secretaria> secretarias) {
    	this.secretarias = secretarias;
    }
}
