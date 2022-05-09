package com.aps.trabalhoAps.requests;

import java.util.UUID;

import com.aps.trabalhoAps.models.Professor;
import com.aps.trabalhoAps.models.Secretaria;

public class TurmaRequest {
	 private UUID professor;
	 private UUID secretaria;
	 private String nomeCurso;
	public UUID getProfessor() {
		return professor;
	}
	public void setProfessor(UUID professor) {
		this.professor = professor;
	}
	public UUID getSecretaria() {
		return secretaria;
	}
	public void setSecretaria(UUID secretaria) {
		this.secretaria = secretaria;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
}
