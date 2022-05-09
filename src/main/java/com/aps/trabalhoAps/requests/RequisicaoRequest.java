package com.aps.trabalhoAps.requests;

import java.util.UUID;

public class RequisicaoRequest {
	private String titulo;
	private String subtitulo;
	private String descricao;
	private UUID secretaria;
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getSubtitulo() {
		return subtitulo;
	}
	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public UUID getSecretaria() {
		return secretaria;
	}
	public void setSecretaria(UUID secretaria) {
		this.secretaria = secretaria;
	}
}
