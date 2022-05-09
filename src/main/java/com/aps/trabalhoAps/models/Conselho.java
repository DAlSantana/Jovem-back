package com.aps.trabalhoAps.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Conselho")
public class Conselho implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String nome;
    
    @Column(nullable = false)
    private String senha;
    
    @OneToMany
    @JoinColumn(name="secretaria_id")
    private List<Secretaria> secretarias;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UUID getId() {
        return id;
    }
    
    public String getSenha() {
    	return this.senha;
    }
    
    public void setSenha(String senha) {
    	this.senha = senha;
    }

}
