package com.aps.trabalhoAps.controllers;

import com.aps.trabalhoAps.models.Secretaria;
import com.aps.trabalhoAps.services.SecretariaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/secretaria")
public class SecretariaController {
    final SecretariaService secretariaService;

    public SecretariaController(SecretariaService secretariaService) {
        this.secretariaService = secretariaService;
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> criarSecretaria(@PathVariable(value = "id") UUID id, @RequestBody Secretaria secretaria){
         var conselho =  secretariaService.findById(id);
         if(!conselho.isPresent()) {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conselho not found."); }

        return ResponseEntity.status(HttpStatus.CREATED).body(secretariaService.save(secretaria));

    }
}
