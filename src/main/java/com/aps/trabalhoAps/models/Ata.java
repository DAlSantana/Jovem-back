package com.aps.trabalhoAps.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "Ata")
public class Ata {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column
    private String titulo;
    
    @Column
    private String subtitulo;
    
    @Column
    private String descricao;
    
    @ManyToOne
    private Requisicao requisicao;
    
    public UUID getId(){
    	return this.id;
    }
    
    public String getTitulo(){
		return titulo;
    }
    
    public void setTitulo(String titulo) {
    	this.titulo = titulo;
    }
    
    public String getSubtitulo() {
    	return this.subtitulo;
    }
    
    public void setSubtitulo(String subtitulo) {
    	this.subtitulo = subtitulo;
    }
    
    public String getDescricao() {
    	return this.descricao;
    }
    
    public void setDescricao(String descricao) {
    	this.descricao = descricao;
    }
    
    public Requisicao getRequisicao() {
    	return this.requisicao;
    }
    
    public void setRequisicao(Requisicao requisicao){
    	this.requisicao = requisicao;
    }
    
    
}
