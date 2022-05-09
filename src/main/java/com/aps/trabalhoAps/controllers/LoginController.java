package com.aps.trabalhoAps.controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aps.trabalhoAps.domain.Error;
import com.aps.trabalhoAps.services.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/{profile}")
	public ResponseEntity<?> login(@PathVariable(value = "profile", required = true) String profile,
			@RequestHeader(value = "id", required = true) UUID id,
			@RequestHeader(value = "password", required = true) String password) {
		Optional<?> login = loginService.login(profile, id, password);
		if (login.isEmpty()) {
			Error error = new Error();
			error.setStatus(HttpStatus.FORBIDDEN);
			error.setMessage("ID ou senha incorretos para o perfil definido");
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
		}
		return ResponseEntity.status(HttpStatus.OK).body(login.get());
	}

}
