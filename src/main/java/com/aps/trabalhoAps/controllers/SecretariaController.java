package com.aps.trabalhoAps.controllers;

import com.aps.trabalhoAps.domain.Error;
import com.aps.trabalhoAps.models.Secretaria;
import com.aps.trabalhoAps.requests.SecretariaRequest;
import com.aps.trabalhoAps.services.SecretariaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/secretaria")
public class SecretariaController {
	@Autowired
    private SecretariaService secretariaService;

    @PostMapping("/{id}")
    public ResponseEntity<?> criarSecretaria(@PathVariable(value = "id") UUID id, @RequestBody SecretariaRequest secretaria){
        Optional<Secretaria> secretariaOpt = secretariaService.save(id,secretaria);
        if(secretariaOpt.isEmpty()) {
        	Error error = new Error();
        	error.setStatus(HttpStatus.NOT_FOUND);
        	error.setMessage("Conselho não encontrado");
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(secretariaOpt.get());

    }
    
    @GetMapping("/{id}")
    public ResponseEntity<List<Secretaria>> listarSecretarias(@PathVariable(value = "id") UUID id){
    	return ResponseEntity.status(HttpStatus.OK).body(secretariaService.listarSecretarias(id));
    }
    
}
