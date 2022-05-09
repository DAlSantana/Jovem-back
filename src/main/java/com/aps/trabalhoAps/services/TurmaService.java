package com.aps.trabalhoAps.services;

import com.aps.trabalhoAps.domain.Error;
import com.aps.trabalhoAps.models.Ata;
import com.aps.trabalhoAps.models.Professor;
import com.aps.trabalhoAps.models.Secretaria;
import com.aps.trabalhoAps.models.Turma;
import com.aps.trabalhoAps.repositories.ProfessorRepository;
import com.aps.trabalhoAps.repositories.SecretariaRepository;
import com.aps.trabalhoAps.repositories.TurmaRepository;
import com.aps.trabalhoAps.requests.TurmaRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

@Service
public class TurmaService {
    @Autowired
	private TurmaRepository turmaRepository;
    
    @Autowired
    private ProfessorRepository professorRepository;
    
    @Autowired
    private SecretariaRepository secretariaRepository;

    @Transactional
    public Optional<?> save(TurmaRequest turmaRequest){
    	Optional<Professor> professor = professorRepository.findById(turmaRequest.getProfessor());
    	Optional<Secretaria> secretaria = secretariaRepository.findById(turmaRequest.getSecretaria());
    	if(professor.isEmpty()) {
    		Error error = new Error();
    		error.setStatus(HttpStatus.NOT_FOUND);
    		error.setMessage("Professor não encontrado");
    	}
    	
    	if(secretaria.isEmpty()) {
    		Error error = new Error();
    		error.setStatus(HttpStatus.NOT_FOUND);
    		error.setMessage("Secretaria não encontrado");
    	}
    	
    	Turma turma = new Turma();
    	turma.setProfessor(professor.get());
    	turma.setNomeCurso(turmaRequest.getNomeCurso());
    	turma.setSecretaria(secretaria.get());
        return Optional.of(turmaRepository.save(turma));
    }

	public List<Turma> findBySecretariaId(UUID secretaria_id) {
		return turmaRepository.findBySecretariaId(secretaria_id);
	}
    
    public List<Turma> recuperarTodos() {
        return turmaRepository.findAll();
    }
}
