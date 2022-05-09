package com.aps.trabalhoAps.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Requisicao")
public class Requisicao implements Serializable {
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
    private Secretaria secretaria;
    
    @OneToMany
    @JoinColumn(name="ata_id")
    private List<Ata> atas;

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
    
    public Secretaria getSecretaria() {
    	return this.secretaria;
    }
    
    public void setSecretaria(Secretaria secretaria) {
    	this.secretaria = secretaria;
    }
}
