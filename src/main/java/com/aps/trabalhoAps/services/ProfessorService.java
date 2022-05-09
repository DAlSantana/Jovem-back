package com.aps.trabalhoAps.services;

import com.aps.trabalhoAps.domain.Error;
import com.aps.trabalhoAps.models.Aluno;
import com.aps.trabalhoAps.models.Professor;
import com.aps.trabalhoAps.models.Secretaria;
import com.aps.trabalhoAps.models.Turma;
import com.aps.trabalhoAps.repositories.ProfessorRepository;
import com.aps.trabalhoAps.repositories.SecretariaRepository;
import com.aps.trabalhoAps.repositories.TurmaRepository;
import com.aps.trabalhoAps.requests.ProfessorRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

@Service
public class ProfessorService {

	@Autowired
    private ProfessorRepository professorRepository;
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@Autowired
	private SecretariaRepository secretariaRepository;

    @Transactional
    public Optional<?> save(ProfessorRequest professorRequest){
    	Professor professor = new Professor();
    	List<Secretaria> secretarias = new ArrayList<Secretaria>();

    	for(UUID secretariaId : professorRequest.getSecretarias()) {
    		var secretaria = this.secretariaRepository.findById(secretariaId);
    		if(secretaria.isEmpty()) {
    			Error error = new Error();
        		error.setStatus(HttpStatus.NOT_FOUND);
        		error.setMessage("Secretaria não encontrada");
    			return Optional.of(error);
    		} 
    		secretarias.add(secretaria.get());
    	}
    	
    	professor.setCpf(professorRequest.getCpf());
    	professor.setNome(professorRequest.getNome());
    	professor.setSecretarias(secretarias);
        return Optional.of(professorRepository.save(professor));
    }

    public Page<Professor> recuperarTodos(Pageable pageable) {
        return professorRepository.findAll(pageable);
    }
}
