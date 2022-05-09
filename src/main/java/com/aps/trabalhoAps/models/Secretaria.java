package com.aps.trabalhoAps.models;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Secretaria")
public class Secretaria {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @ManyToOne
    private Conselho conselho;
    
    @OneToMany
    @JoinColumn(name="turma_id")
    private List<Turma> turmas;
    
    @OneToMany
    @JoinColumn(name="requisicao_id")
    private List<Requisicao> requisicoes;
    
    @Column(nullable = false, unique = true)
    private String nome;
    
    @Column(nullable = false)
    private String endereco;
    
    @Column(nullable = false)
    private String telefone;
    
    @Column(nullable = false)
    private String senha;
    
    
    @ManyToMany
    private List<Professor> professores;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    
    public void setConselho(Conselho conselho) {
    	this.conselho = conselho;
    }
    
    public String getConselho() {
    	return this.conselho.getNome();
    }
    
    public String getNome() {
    	return this.nome;
    }
    
    public void setNome(String nome) {
    	this.nome = nome;
    }
    
    public String getEndereco() {
    	return this.endereco;
    }
    
    public void setEndereco(String endereco) {
    	this.endereco = endereco;
    }
    
    public String getTelefone() {
    	return this.telefone;
    }

    public void setTelefone(String telefone) {
    	this.telefone = telefone;
    }

    public void setSenha(String senha) {
    	this.senha = senha;
    }
}
