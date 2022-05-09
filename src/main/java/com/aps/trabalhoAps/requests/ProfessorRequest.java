package com.aps.trabalhoAps.requests;

import java.util.List;
import java.util.UUID;

public class ProfessorRequest {
	private String nome;
	private String cpf;
	private List<UUID> secretarias;
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
	public List<UUID> getSecretarias() {
		return secretarias;
	}
	public void setSecretarias(List<UUID> secretarias) {
		this.secretarias = secretarias;
	}
}
