package com.aps.trabalhoAps.requests;

import java.util.UUID;

import com.aps.trabalhoAps.models.Turma;

public class AlunoRequest {
	private String nome;
	private String cpf;
	private UUID turma;
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
	public UUID getTurma() {
		return turma;
	}
	public void setTurma(UUID turma) {
		this.turma = turma;
	}
}
