package com.aps.trabalhoAps.services;

import com.aps.trabalhoAps.domain.Error;
import com.aps.trabalhoAps.models.Aluno;
import com.aps.trabalhoAps.models.Turma;
import com.aps.trabalhoAps.repositories.AlunoRepository;
import com.aps.trabalhoAps.repositories.TurmaRepository;
import com.aps.trabalhoAps.requests.AlunoRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.transaction.Transactional;

@Service
public class AlunoService {
    @Autowired
	private AlunoRepository alunoRepository;
    
    @Autowired
    private TurmaRepository turmaRepository;

    @Transactional
    public Optional<?> save(AlunoRequest alunoRequest){
    	Optional<Turma> turma = turmaRepository.findById(alunoRequest.getTurma());
    	if(turma.isEmpty()) {
    		Error error = new Error();
    		error.setStatus(HttpStatus.NOT_FOUND);
    		error.setMessage("Turma não encontrada");
    		return Optional.of(error);
    	}
    	Aluno aluno = new Aluno();
    	aluno.setCpf(alunoRequest.getCpf());
    	aluno.setNome(alunoRequest.getNome());
    	aluno.setTurma(turma.get());
        return Optional.of(alunoRepository.save(aluno));
    }

    public Page<Aluno> recuperarTodos(Pageable pageable) {
        return alunoRepository.findAll(pageable);
    }

}
