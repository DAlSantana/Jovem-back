package com.aps.trabalhoAps.controllers;

import com.aps.trabalhoAps.domain.Error;
import com.aps.trabalhoAps.models.Ata;
import com.aps.trabalhoAps.requests.AtaRequest;
import com.aps.trabalhoAps.requests.SecretariaRequest;
import com.aps.trabalhoAps.services.AtaService;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/ata")
public class AtaController {
    final AtaService ataService;

    public AtaController(AtaService ataService) {
        this.ataService = ataService;
    }

    @PostMapping
    public ResponseEntity<Object> salvarAta(@RequestBody AtaRequest ataRequest){
    	var ata = ataService.save(ataRequest);
    	if(ata.get() instanceof Error) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ata.get());
    	}
        return ResponseEntity.status(HttpStatus.CREATED).body(ata.get());
    }

    @GetMapping
    public List<Ata> findAll(){
        return ataService.recuperarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Ata>> findByRequisicaoId(@PathVariable(value = "id") UUID id) {
        return new ResponseEntity<List<Ata>>(ataService.findByReqId(id), HttpStatus.OK);
    }
}
