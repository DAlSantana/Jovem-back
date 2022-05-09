package com.aps.trabalhoAps.controllers;

import com.aps.trabalhoAps.domain.Error;
import com.aps.trabalhoAps.models.Requisicao;
import com.aps.trabalhoAps.requests.RequisicaoRequest;
import com.aps.trabalhoAps.services.RequisicaoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requisicao")
public class RequisicaoController {

	@Autowired
    private RequisicaoService requisicaoService;

    @PostMapping
    public ResponseEntity<Object> salvarInformativo(@RequestBody RequisicaoRequest requisicaoRequest){
    	var requisicao = requisicaoService.save(requisicaoRequest);
    	if(requisicao.get() instanceof Error) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(requisicao.get());
    	}
        return ResponseEntity.status(HttpStatus.CREATED).body(requisicao.get());
    }

    
    @GetMapping
    public List<Requisicao> findAll(){
        return requisicaoService.recuperarTodos();
    }
}
