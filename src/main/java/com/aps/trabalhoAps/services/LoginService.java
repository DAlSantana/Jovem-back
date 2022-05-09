package com.aps.trabalhoAps.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aps.trabalhoAps.models.Conselho;
import com.aps.trabalhoAps.models.Secretaria;
import com.aps.trabalhoAps.repositories.ConselhoRepository;
import com.aps.trabalhoAps.repositories.SecretariaRepository;

@Service
public class LoginService {
	@Autowired 
	private ConselhoRepository conselhoRepository;
	
	@Autowired
	private SecretariaRepository secretariaRepository;
	
	public Optional<?> login(String profile, UUID id, String password){
		if(profile.toLowerCase().equals("secretaria")) {
			Secretaria secretaria = secretariaRepository.findByIdAndSenha(id, password);
			if(secretaria == null) return Optional.empty();
			return Optional.of(secretaria);
		}else if(profile.toLowerCase().equals("conselho")) {
			Conselho conselho = conselhoRepository.findByIdAndSenha(id, password);
			if(conselho == null) return Optional.empty();
			return Optional.of(conselho);
		}
		return Optional.empty();
	}
}
